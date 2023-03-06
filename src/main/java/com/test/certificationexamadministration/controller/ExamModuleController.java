package com.test.certificationexamadministration.controller;

import com.test.certificationexamadministration.exception.InvalidInputException;
import com.test.certificationexamadministration.model.ExamModule;
import com.test.certificationexamadministration.model.request.ExamModuleRequest;
import com.test.certificationexamadministration.model.response.SuccessResponse;
import com.test.certificationexamadministration.service.ExamModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(UrlMappings.EXAM_MODULE_URL)
public class ExamModuleController {

    private final ExamModuleService examModuleService;

    @Autowired
    public ExamModuleController(ExamModuleService examModuleService) {
        this.examModuleService = examModuleService;
    }

    @PostMapping
    public ResponseEntity add(@RequestBody @Valid ExamModuleRequest examModuleRequest, BindingResult errors) {

        if (errors.hasErrors()) {
            throw new InvalidInputException();
        }

        ExamModule examModuleData = examModuleService.add(examModuleRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<>(HttpStatus.CREATED.name(), "Successfully added exam module", examModuleData));
    }

    @GetMapping
    public ResponseEntity getAll() {
        List<ExamModule> examModuleData = examModuleService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>(HttpStatus.OK.name(), "Successfully got all exam modules", examModuleData));
    }

    @PatchMapping("/{code}")
    public ResponseEntity update(@PathVariable("code") String code, String newName, String newLevelCode) {
        ExamModule examModule = examModuleService.update(code, newName, newLevelCode);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>(HttpStatus.OK.name(), "Successfully updated Exam Module", examModule));
    }

    @DeleteMapping("/{code}")
    public ResponseEntity delete(@PathVariable("code") String code) {
        examModuleService.delete(code);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>(HttpStatus.OK.name(), "Successfully deleted Exam Module", "Exam Module " + code + " has been deleted"));
    }

}
