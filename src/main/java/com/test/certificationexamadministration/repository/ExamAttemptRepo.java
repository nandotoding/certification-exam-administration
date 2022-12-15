package com.test.certificationexamadministration.repository;

import com.test.certificationexamadministration.model.ExamAttempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamAttemptRepo extends JpaRepository<ExamAttempt, String> {
}
