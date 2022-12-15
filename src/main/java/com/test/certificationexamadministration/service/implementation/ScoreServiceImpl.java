package com.test.certificationexamadministration.service.implementation;

import com.test.certificationexamadministration.exception.NotFoundException;
import com.test.certificationexamadministration.model.ExamAttempt;
import com.test.certificationexamadministration.model.Score;
import com.test.certificationexamadministration.model.request.ScoreRequest;
import com.test.certificationexamadministration.repository.ExamAttemptRepo;
import com.test.certificationexamadministration.repository.ScoreRepo;
import com.test.certificationexamadministration.service.ScoreService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

}
