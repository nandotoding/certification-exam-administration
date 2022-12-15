package com.test.certificationexamadministration.controller;

import com.test.certificationexamadministration.exception.InvalidInputException;
import com.test.certificationexamadministration.model.User;
import com.test.certificationexamadministration.model.request.UserRequest;
import com.test.certificationexamadministration.model.response.SuccessResponse;
import com.test.certificationexamadministration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity add(@Valid @RequestBody UserRequest userRequest, BindingResult errors) {

        if (errors.hasErrors()) {
            throw new InvalidInputException();
        }

        User userData = userService.add(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<>(HttpStatus.CREATED.name(), "Successfully added user", userData));
    }

    @GetMapping
    public ResponseEntity getAll() {
        List<User> userData = userService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>(HttpStatus.OK.name(), "Successfully got all users", userData));
    }

    @GetMapping("/{username}")
    public ResponseEntity getByUsername(@PathVariable("username") String username) {
        User userData = userService.getWhereUsernameEquals(username);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>(HttpStatus.OK.name(), "Successfully got the user", userData));
    }

    @PatchMapping("/{username}")
    public ResponseEntity update(@PathVariable("username") String username, @RequestParam String password, @RequestParam String newPass) {
        User userData = userService.update(username, password, newPass);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>(HttpStatus.OK.name(), "Successfully updated password", userData));
    }

    @DeleteMapping("/{username}")
    public ResponseEntity delete(@PathVariable("username") String username, @RequestParam String password) {
        userService.delete(username, password);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>(HttpStatus.OK.name(), "Successfully deleted user", username));
    }


}
