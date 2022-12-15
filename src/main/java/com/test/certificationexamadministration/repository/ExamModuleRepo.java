package com.test.certificationexamadministration.repository;

import com.test.certificationexamadministration.model.ExamModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamModuleRepo extends JpaRepository<ExamModule, String> {
}
