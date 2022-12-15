package com.test.certificationexamadministration.controller;

import com.test.certificationexamadministration.model.ExamAttempt;
import com.test.certificationexamadministration.model.request.ExamAttemptRequest;
import com.test.certificationexamadministration.model.response.SuccessResponse;
import com.test.certificationexamadministration.service.ExamAttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exam-attempts")
public class ExamAttemptController {

    private final ExamAttemptService examAttemptService;

    @Autowired
    public ExamAttemptController(ExamAttemptService examAttemptService) {
        this.examAttemptService = examAttemptService;
    }

    @PostMapping
    public ResponseEntity add(@RequestBody ExamAttemptRequest examAttemptRequest) {
        ExamAttempt examAttemptData = examAttemptService.add(examAttemptRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<>(HttpStatus.CREATED.name(), "Successfully added exam attempt", examAttemptData));
    }

}
