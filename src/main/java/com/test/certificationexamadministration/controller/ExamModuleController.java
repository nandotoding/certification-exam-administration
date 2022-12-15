package com.test.certificationexamadministration.controller;

import com.test.certificationexamadministration.model.ExamModule;
import com.test.certificationexamadministration.model.request.ExamModuleRequest;
import com.test.certificationexamadministration.model.response.SuccessResponse;
import com.test.certificationexamadministration.service.ExamModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exam-modules")
public class ExamModuleController {

    private final ExamModuleService examModuleService;

    @Autowired
    public ExamModuleController(ExamModuleService examModuleService) {
        this.examModuleService = examModuleService;
    }

    @PostMapping
    public ResponseEntity add(@RequestBody ExamModuleRequest examModuleRequest) {
        ExamModule examModuleData = examModuleService.add(examModuleRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<>(HttpStatus.CREATED.name(), "Successfully added exam module", examModuleData));
    }

}
