package com.test.certificationexamadministration.service;

import com.test.certificationexamadministration.model.ExamAttempt;
import com.test.certificationexamadministration.model.request.ExamAttemptRequest;

import java.util.List;

public interface ExamAttemptService {

    ExamAttempt add(ExamAttemptRequest examAttemptRequest);
    List<ExamAttempt> getAll();

}
