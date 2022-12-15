package com.test.certificationexamadministration.controller;

import com.test.certificationexamadministration.model.ExamLevel;
import com.test.certificationexamadministration.model.request.ExamLevelRequest;
import com.test.certificationexamadministration.model.response.SuccessResponse;
import com.test.certificationexamadministration.service.ExamLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exam-levels")
public class ExamLevelController {

    private final ExamLevelService examLevelService;

    @Autowired
    public ExamLevelController(ExamLevelService examLevelService) {
        this.examLevelService = examLevelService;
    }

    @PostMapping
    public ResponseEntity add(@RequestBody ExamLevelRequest examLevelRequest) {
        ExamLevel examLevelData = examLevelService.add(examLevelRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<>(HttpStatus.CREATED.name(), "Successfully added exam level", examLevelData));
    }

}
