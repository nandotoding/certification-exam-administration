package com.test.certificationexamadministration.repository;

import com.test.certificationexamadministration.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, String> {

    @Query(value = "SELECT * FROM users WHERE username = :username LIMIT 1", nativeQuery = true)
    User findWhereUsernameEquals(String username);

}
