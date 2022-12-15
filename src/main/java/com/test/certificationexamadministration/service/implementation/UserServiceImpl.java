package com.test.certificationexamadministration.service.implementation;

import com.test.certificationexamadministration.model.User;
import com.test.certificationexamadministration.model.request.UserRequest;
import com.test.certificationexamadministration.repository.UserRepo;
import com.test.certificationexamadministration.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, ModelMapper modelMapper) {
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public User add(UserRequest userRequest) {
        User user = modelMapper.map(userRequest, User.class);
        userRepo.save(user);
        return user;
    }

    @Override
    public User getWhereUsernameEquals(String username) {
        return userRepo.findWhereUsernameEquals(username);
    }

}
