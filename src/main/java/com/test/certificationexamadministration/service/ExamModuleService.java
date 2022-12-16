package com.test.certificationexamadministration.service;

import com.test.certificationexamadministration.model.ExamModule;
import com.test.certificationexamadministration.model.request.ExamModuleRequest;

import java.util.List;

public interface ExamModuleService {

    ExamModule add(ExamModuleRequest examModuleRequest);
    List<ExamModule> getAll();
    ExamModule update(String code, String newName, String newLevelCode);
    void delete(String code);

}
