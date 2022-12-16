package com.test.certificationexamadministration.service.implementation;

import com.test.certificationexamadministration.exception.InvalidInputException;
import com.test.certificationexamadministration.exception.NotFoundException;
import com.test.certificationexamadministration.exception.ParentEntityDeletionException;
import com.test.certificationexamadministration.model.ExamLevel;
import com.test.certificationexamadministration.model.request.ExamLevelRequest;
import com.test.certificationexamadministration.repository.ExamLevelRepo;
import com.test.certificationexamadministration.service.ExamLevelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        ExamLevel registeredExamLevel = examLevelRepo.findWhereLevelCodeEquals(examLevelRequest.getLevelCode());

        if (registeredExamLevel != null) {
            throw new InvalidInputException("Exam Level " + examLevelRequest.getLevelCode() + " is already registered");
        }

        ExamLevel examLevel = modelMapper.map(examLevelRequest, ExamLevel.class);
        examLevelRepo.save(examLevel);
        return examLevel;
    }

    @Override
    public List<ExamLevel> getAll() {
        List<ExamLevel> examLevels = examLevelRepo.findAll();

        if (examLevels.isEmpty()) {
            throw new NotFoundException("Exam Level data not found");
        }

        return examLevels;
    }

    @Override
    public ExamLevel getWhereLevelCodeEquals(String code) {
        ExamLevel examLevel = examLevelRepo.findWhereLevelCodeEquals(code);

        if (examLevel == null) {
            throw new NotFoundException("Exam Level not found");
        }

        return examLevel;
    }

    @Override
    public ExamLevel updateName(String code, String name) {
        ExamLevel examLevel = examLevelRepo.findWhereLevelCodeEquals(code);

        if (examLevel == null) {
            throw new NotFoundException("Exam Level not found");
        }

        examLevel.setLevelName(name);
        examLevelRepo.save(examLevel);

        return examLevel;
    }

    @Override
    public void delete(String code) {
        ExamLevel examLevel = examLevelRepo.findWhereLevelCodeEquals(code);

        if (examLevel == null) {
            throw new NotFoundException("Exam Level not found");
        }

        try {
            examLevelRepo.delete(examLevel);
        } catch (Exception e) {
            throw new ParentEntityDeletionException();
        }
    }

}
