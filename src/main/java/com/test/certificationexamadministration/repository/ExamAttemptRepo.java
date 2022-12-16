package com.test.certificationexamadministration.repository;

import com.test.certificationexamadministration.model.ExamAttempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamAttemptRepo extends JpaRepository<ExamAttempt, String> {

    @Query(value = "SELECT * FROM exam_attempts", nativeQuery = true)
    List<ExamAttempt> findAll();

}
