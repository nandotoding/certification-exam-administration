package com.test.certificationexamadministration.service.implementation;

import com.test.certificationexamadministration.model.ExamLevel;
import com.test.certificationexamadministration.model.request.ExamLevelRequest;
import com.test.certificationexamadministration.repository.ExamLevelRepo;
import com.test.certificationexamadministration.service.ExamLevelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamLevelServiceImpl implements ExamLevelService {

    private final ExamLevelRepo examLevelRepo;
    private final ModelMapper modelMapper;

    @Autowired
    public ExamLevelServiceImpl(ExamLevelRepo examLevelRepo, ModelMapper modelMapper) {
        this.examLevelRepo = examLevelRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public ExamLevel add(ExamLevelRequest examLevelRequest) {
        ExamLevel examLevel = modelMapper.map(examLevelRequest, ExamLevel.class);
        examLevelRepo.save(examLevel);
        return examLevel;
    }

    @Override
    public ExamLevel getWhereLevelCodeEquals(String code) {
        return examLevelRepo.findWhereLevelCodeEquals(code);
    }

}
