package com.test.certificationexamadministration.service.implementation;

import com.test.certificationexamadministration.exception.NotFoundException;
import com.test.certificationexamadministration.model.ExamAttempt;
import com.test.certificationexamadministration.model.Score;
import com.test.certificationexamadministration.model.ScoreReport;
import com.test.certificationexamadministration.model.request.ScoreRequest;
import com.test.certificationexamadministration.repository.ExamAttemptRepo;
import com.test.certificationexamadministration.repository.ScoreRepo;
import com.test.certificationexamadministration.service.ScoreService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ScoreServiceImpl implements ScoreService {

    private final ScoreRepo scoreRepo;
    private final ExamAttemptRepo examAttemptRepo;
    private final ModelMapper modelMapper;

    @Autowired
    public ScoreServiceImpl(ScoreRepo scoreRepo, ExamAttemptRepo examAttemptRepo, ModelMapper modelMapper) {
        this.scoreRepo = scoreRepo;
        this.examAttemptRepo = examAttemptRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public Score add(ScoreRequest scoreRequest) {
        Score score = new Score();
        Optional<ExamAttempt> examAttemptOpt = examAttemptRepo.findById(scoreRequest.getAttemptId());
        ExamAttempt examAttempt = modelMapper.map(examAttemptOpt, ExamAttempt.class);

        if (examAttempt == null) {
            throw new NotFoundException("Exam Attempt not found");
        }

        score.setExamAttempt(examAttempt);
        score.setScore(scoreRequest.getScore());
        scoreRepo.save(score);

        return score;
    }

    @Override
    public List<Score> getAll() {
        return scoreRepo.findAll();
    }

    @Override
    public List<ScoreReport> getScoreReport() {
        List<Score> scores = scoreRepo.findAll();

        List<ScoreReport> scoreReport = scores
                .stream()
                .map(score -> {
                    ScoreReport report = new ScoreReport();
                    report.setAttemptDate(score.getExamAttempt().getAttemptDate());
                    report.setUsername(score.getExamAttempt().getUser().getUsername());
                    report.setModuleName(score.getExamAttempt().getExamModule().getModuleName());
                    report.setLevelName(score.getExamAttempt().getExamModule().getExamLevel().getLevelName());
                    report.setScore(score.getScore());
                    return report;
                }).collect(Collectors.toList());

        if (scoreReport.isEmpty()) {
            throw new NotFoundException("Score Report is empty");
        }

        return scoreReport;
    }

    @Override
    public List<ScoreReport> getScoreReportByUsername(String username) {
        List<ScoreReport> scoreReports = getScoreReport();

        List<ScoreReport> filteredScoreReport = scoreReports
                .stream()
                .filter(report -> report.getUsername().equals(username))
                .collect(Collectors.toList());

        if (filteredScoreReport.isEmpty()) {
            throw new NotFoundException("Score Report not found");
        }

        return filteredScoreReport;
    }

}
