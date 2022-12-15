package com.test.certificationexamadministration.service.implementation;

import com.test.certificationexamadministration.exception.NotFoundException;
import com.test.certificationexamadministration.model.ExamLevel;
import com.test.certificationexamadministration.model.ExamModule;
import com.test.certificationexamadministration.model.request.ExamModuleRequest;
import com.test.certificationexamadministration.repository.ExamLevelRepo;
import com.test.certificationexamadministration.repository.ExamModuleRepo;
import com.test.certificationexamadministration.service.ExamModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
