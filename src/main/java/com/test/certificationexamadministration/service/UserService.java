package com.test.certificationexamadministration.service;

import com.test.certificationexamadministration.model.User;
import com.test.certificationexamadministration.model.request.UserRequest;

public interface UserService {
    User add(UserRequest userRequest);
}
