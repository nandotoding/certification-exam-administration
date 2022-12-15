package com.test.certificationexamadministration.service;

import com.test.certificationexamadministration.model.ExamLevel;
import com.test.certificationexamadministration.model.request.ExamLevelRequest;

public interface ExamLevelService {

    ExamLevel add(ExamLevelRequest examLevelRequest);
    ExamLevel getWhereLevelCodeEquals(String code);

}
