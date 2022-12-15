package com.test.certificationexamadministration.repository;

import com.test.certificationexamadministration.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String> {
}
