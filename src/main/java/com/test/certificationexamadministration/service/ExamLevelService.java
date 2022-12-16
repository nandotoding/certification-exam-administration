package com.test.certificationexamadministration.service;

import com.test.certificationexamadministration.model.ExamLevel;
import com.test.certificationexamadministration.model.request.ExamLevelRequest;

import java.util.List;

public interface ExamLevelService {

    ExamLevel add(ExamLevelRequest examLevelRequest);
    List<ExamLevel> getAll();
    ExamLevel getWhereLevelCodeEquals(String code);
    ExamLevel updateName(String code, String name);
    void delete(String code);

}
