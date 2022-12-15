package com.test.certificationexamadministration.repository;

import com.test.certificationexamadministration.model.ExamLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamLevelRepo extends JpaRepository<ExamLevel, String> {

    @Query(value = "SELECT * FROM exam_levels WHERE level_code = :code LIMIT 1", nativeQuery = true)
    ExamLevel findWhereLevelCodeEquals(String code);

}
