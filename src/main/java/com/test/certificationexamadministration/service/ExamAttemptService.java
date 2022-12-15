package com.test.certificationexamadministration.service;

import com.test.certificationexamadministration.model.ExamAttempt;
import com.test.certificationexamadministration.model.request.ExamAttemptRequest;

public interface ExamAttemptService {

    ExamAttempt add(ExamAttemptRequest examAttemptRequest);

}
