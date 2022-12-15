package com.test.certificationexamadministration.service.implementation;

import com.test.certificationexamadministration.model.ExamAttempt;
import com.test.certificationexamadministration.model.request.ExamAttemptRequest;
import com.test.certificationexamadministration.repository.ExamAttemptRepo;
import com.test.certificationexamadministration.service.ExamAttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamAttemptServiceImpl implements ExamAttemptService {

    private final ExamAttemptRepo examAttemptRepo;

    @Autowired
    public ExamAttemptServiceImpl(ExamAttemptRepo examAttemptRepo) {
        this.examAttemptRepo = examAttemptRepo;
    }

    @Override
    public ExamAttempt add(ExamAttemptRequest examAttemptRequest) {
        return null;
    }
}
