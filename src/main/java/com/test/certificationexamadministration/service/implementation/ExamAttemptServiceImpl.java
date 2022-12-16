package com.test.certificationexamadministration.service.implementation;

import com.test.certificationexamadministration.exception.InvalidInputException;
import com.test.certificationexamadministration.exception.NotFoundException;
import com.test.certificationexamadministration.model.ExamAttempt;
import com.test.certificationexamadministration.model.ExamModule;
import com.test.certificationexamadministration.model.User;
import com.test.certificationexamadministration.model.request.ExamAttemptRequest;
import com.test.certificationexamadministration.repository.ExamAttemptRepo;
import com.test.certificationexamadministration.repository.ExamModuleRepo;
import com.test.certificationexamadministration.repository.UserRepo;
import com.test.certificationexamadministration.service.ExamAttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamAttemptServiceImpl implements ExamAttemptService {

    private final ExamAttemptRepo examAttemptRepo;
    private final UserRepo userRepo;
    private final ExamModuleRepo examModuleRepo;

    @Autowired
    public ExamAttemptServiceImpl(ExamAttemptRepo examAttemptRepo, UserRepo userRepo, ExamModuleRepo examModuleRepo) {
        this.examAttemptRepo = examAttemptRepo;
        this.userRepo = userRepo;
        this.examModuleRepo = examModuleRepo;
    }

    @Override
    public ExamAttempt add(ExamAttemptRequest examAttemptRequest) {
        ExamAttempt examAttempt = new ExamAttempt();
        User user = userRepo.findWhereUsernameEquals(examAttemptRequest.getUsername());
        ExamModule examModule = examModuleRepo.findWhereModuleCodeEquals(examAttemptRequest.getModuleCode());

        if (user == null || examModule == null) {
            throw new NotFoundException("Username or Module Code is not registered");
        }

        examAttempt.setUser(user);
        examAttempt.setExamModule(examModule);
        examAttempt.setAttemptDate(examAttemptRequest.getAttemptDate());
        examAttemptRepo.save(examAttempt);

        return examAttempt;
    }

    @Override
    public List<ExamAttempt> getAll() {
        List<ExamAttempt> examAttempts = examAttemptRepo.findAll();

        if (examAttempts.isEmpty()) {
            throw new NotFoundException("Exam Attempts not found");
        }

        return examAttempts;
    }

}
