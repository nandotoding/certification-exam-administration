package com.test.certificationexamadministration.service.implementation;

import com.test.certificationexamadministration.exception.InvalidInputException;
import com.test.certificationexamadministration.exception.NotFoundException;
import com.test.certificationexamadministration.model.User;
import com.test.certificationexamadministration.model.request.UserRequest;
import com.test.certificationexamadministration.repository.UserRepo;
import com.test.certificationexamadministration.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<User> getAll() {
        List<User> users = userRepo.findAll();

        if (users.isEmpty()) {
            throw new NotFoundException("User data is empty");
        }

        return users;
    }

    @Override
    public User getWhereUsernameEquals(String username) {
        User user = userRepo.findWhereUsernameEquals(username);

        if (user == null) {
            throw new NotFoundException("User not found");
        }

        return user;
    }

    @Override
    public User update(String username, String pass, String newPass) {
        User user = userRepo.findWhereUsernameEquals(username);

        if (user == null) {
            throw new NotFoundException("User not found");
        }

        if (!user.getPassword().equals(pass)) {
            throw new InvalidInputException("Password is wrong");
        }

        user.setPassword(newPass);
        userRepo.save(user);
        return user;
    }

    @Override
    public void delete(String username, String password) {
        User user = userRepo.findWhereUsernameEquals(username);

        if (user == null) {
            throw new NotFoundException("User not found");
        }

        if (!user.getPassword().equals(password)) {
            throw new InvalidInputException("Password is wrong");
        }

        userRepo.delete(user);
    }

}
