package com.test.certificationexamadministration.service.implementation;

import com.test.certificationexamadministration.exception.InvalidInputException;
import com.test.certificationexamadministration.exception.NotFoundException;
import com.test.certificationexamadministration.exception.ParentEntityDeletionException;
import com.test.certificationexamadministration.model.ExamLevel;
import com.test.certificationexamadministration.model.ExamModule;
import com.test.certificationexamadministration.model.request.ExamModuleRequest;
import com.test.certificationexamadministration.repository.ExamLevelRepo;
import com.test.certificationexamadministration.repository.ExamModuleRepo;
import com.test.certificationexamadministration.service.ExamModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamModuleServiceImpl implements ExamModuleService {

    private final ExamModuleRepo examModuleRepo;
    private final ExamLevelRepo examLevelRepo;

    @Autowired
    public ExamModuleServiceImpl(ExamModuleRepo examModuleRepo, ExamLevelRepo examLevelRepo) {
        this.examModuleRepo = examModuleRepo;
        this.examLevelRepo = examLevelRepo;
    }

    @Override
    public ExamModule add(ExamModuleRequest examModuleRequest) {
        ExamModule examModule = new ExamModule();
        ExamModule registeredExamModule = examModuleRepo.findWhereModuleCodeEquals(examModuleRequest.getModuleCode());

        if (registeredExamModule != null) {
            throw new InvalidInputException("Exam Module " + examModuleRequest.getModuleCode() + " is already registered");
        }

        ExamLevel examLevel = examLevelRepo.findWhereLevelCodeEquals(examModuleRequest.getLevelCode());

        if (examLevel == null) {
            throw new NotFoundException("The exam level is not registered");
        }

        examModule.setModuleCode(examModuleRequest.getModuleCode());
        examModule.setModuleName(examModuleRequest.getModuleName());
        examModule.setExamLevel(examLevel);
        examModuleRepo.save(examModule);

        return examModule;
    }

    @Override
    public List<ExamModule> getAll() {
        List<ExamModule> examModules = examModuleRepo.findAll();

        if (examModules.isEmpty()) {
            throw new NotFoundException("Exam Modules not found");
        }

        return examModules;
    }

    @Override
    public ExamModule update(String code, String newName, String newLevelCode) {
        ExamModule examModule = examModuleRepo.findWhereModuleCodeEquals(code);

        if (examModule == null) {
            throw new NotFoundException("Exam Module not found");
        }

        ExamLevel examLevel = examLevelRepo.findWhereLevelCodeEquals(newLevelCode);

        if (examLevel == null) {
            throw new NotFoundException("Exam Level not found");
        }

        examModule.setModuleName(newName);
        examModule.setExamLevel(examLevel);
        examModuleRepo.save(examModule);

        return examModule;
    }

    @Override
    public void delete(String code) {
        ExamModule examModule = examModuleRepo.findWhereModuleCodeEquals(code);

        if (examModule == null) {
            throw new NotFoundException("Exam Module not found");
        }

        try {
            examModuleRepo.delete(examModule);
        } catch (Exception e) {
            throw new ParentEntityDeletionException();
        }
    }

}
