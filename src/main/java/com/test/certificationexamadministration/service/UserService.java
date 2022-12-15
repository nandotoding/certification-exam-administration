package com.test.certificationexamadministration.service;

import com.test.certificationexamadministration.model.User;
import com.test.certificationexamadministration.model.request.UserRequest;

import java.util.List;

public interface UserService {

    User add(UserRequest userRequest);
    List<User> getAll();
    User getWhereUsernameEquals(String username);
    User update(String username, String pass, String newPass);
    void delete(String username, String password);

}
