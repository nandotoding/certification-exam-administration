package com.test.certificationexamadministration.controller;

import com.test.certificationexamadministration.model.ExamLevel;
import com.test.certificationexamadministration.model.request.ExamLevelRequest;
import com.test.certificationexamadministration.model.response.SuccessResponse;
import com.test.certificationexamadministration.service.ExamLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity getAll() {
        List<ExamLevel> examLevelData = examLevelService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>(HttpStatus.OK.name(), "Successfully got all exam level data", examLevelData));
    }

    @GetMapping("/{code}")
    public ResponseEntity getByCode(@PathVariable("code") String code) {
        ExamLevel examLevelData = examLevelService.getWhereLevelCodeEquals(code);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>(HttpStatus.OK.name(), "Successfully got Exam Level", examLevelData));
    }

    @PatchMapping("/{code}")
    public ResponseEntity updateName(@PathVariable("code") String code, @RequestParam String newName) {
        ExamLevel examLevelData = examLevelService.updateName(code, newName);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>(HttpStatus.OK.name(), "Successfully updated Exam Level name", examLevelData));
    }

    @DeleteMapping("/{code}")
    public ResponseEntity delete(@PathVariable("code") String code) {
        examLevelService.delete(code);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>(HttpStatus.OK.name(), "Successfully deleted Exam Level", "Exam Level " + code + " has been deleted"));
    }

}
