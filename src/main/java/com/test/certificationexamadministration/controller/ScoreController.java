package com.test.certificationexamadministration.controller;

import com.test.certificationexamadministration.model.Score;
import com.test.certificationexamadministration.model.ScoreReport;
import com.test.certificationexamadministration.model.request.ScoreRequest;
import com.test.certificationexamadministration.model.response.SuccessResponse;
import com.test.certificationexamadministration.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/report")
    public ResponseEntity getScoreReport() {
        List<ScoreReport> scoreReportData = scoreService.getScoreReport();
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>(HttpStatus.OK.name(), "Successfully got score report", scoreReportData));
    }

}