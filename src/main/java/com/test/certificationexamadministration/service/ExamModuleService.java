package com.test.certificationexamadministration.service;

import com.test.certificationexamadministration.model.ExamModule;
import com.test.certificationexamadministration.model.request.ExamModuleRequest;

public interface ExamModuleService {

    ExamModule add(ExamModuleRequest examModuleRequest);

}
