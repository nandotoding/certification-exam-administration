package com.test.certificationexamadministration.repository;

import com.test.certificationexamadministration.model.ExamModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamModuleRepo extends JpaRepository<ExamModule, String> {

    @Query(value = "SELECT * FROM exam_modules", nativeQuery = true)
    List<ExamModule> findAll();

    @Query(value = "SELECT * FROM exam_modules WHERE module_code = :code LIMIT 1", nativeQuery = true)
    ExamModule findWhereModuleCodeEquals(String code);

}
