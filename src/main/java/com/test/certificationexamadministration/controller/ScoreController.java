package com.test.certificationexamadministration.controller;

import com.test.certificationexamadministration.model.Score;
import com.test.certificationexamadministration.model.request.ScoreRequest;
import com.test.certificationexamadministration.model.response.SuccessResponse;
import com.test.certificationexamadministration.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scores")
public class ScoreController {

    private final ScoreService scoreService;

    @Autowired
    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @PostMapping
    public ResponseEntity add(@RequestBody ScoreRequest scoreRequest) {
        Score scoreData = scoreService.add(scoreRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<>(HttpStatus.CREATED.name(), "Successfully added score", scoreData));
    }

}
