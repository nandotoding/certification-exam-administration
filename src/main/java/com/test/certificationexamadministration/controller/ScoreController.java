package com.test.certificationexamadministration.controller;

import com.test.certificationexamadministration.exception.InvalidInputException;
import com.test.certificationexamadministration.model.Score;
import com.test.certificationexamadministration.model.ScoreReport;
import com.test.certificationexamadministration.model.request.ScoreRequest;
import com.test.certificationexamadministration.model.response.SuccessResponse;
import com.test.certificationexamadministration.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity add(@Valid @RequestBody ScoreRequest scoreRequest, BindingResult errors) {

        if (errors.hasErrors()) {
            throw new InvalidInputException();
        }

        Score scoreData = scoreService.add(scoreRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<>(HttpStatus.CREATED.name(), "Successfully added score", scoreData));
    }

    @GetMapping("/report")
    public ResponseEntity getScoreReport() {
        List<ScoreReport> scoreReportData = scoreService.getScoreReport();
        return ResponseEntity.status(HttpStatus.FOUND).body(new SuccessResponse<>(HttpStatus.FOUND.name(), "Successfully got score report", scoreReportData));
    }

    @GetMapping("/report/{username}")
    public ResponseEntity getScoreReportByUsername(@PathVariable("username") String username) {
        List<ScoreReport> scoreReportData = scoreService.getScoreReportByUsername(username);
        return ResponseEntity.status(HttpStatus.FOUND).body(new SuccessResponse<>(HttpStatus.FOUND.name(), "Successfully got " + username + " score reports", scoreReportData));
    }

}
