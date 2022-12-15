package com.test.certificationexamadministration.repository;

import com.test.certificationexamadministration.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepo extends JpaRepository<Score, String> {
}
