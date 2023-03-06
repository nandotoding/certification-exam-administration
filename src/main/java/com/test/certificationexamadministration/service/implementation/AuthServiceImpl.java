package com.test.certificationexamadministration.service.implementation;

import com.test.certificationexamadministration.exception.UnauthorizedException;
import com.test.certificationexamadministration.model.request.Credential;
import com.test.certificationexamadministration.service.AuthService;
import com.test.certificationexamadministration.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {
    private final JwtUtil jwtUtil;

    @Autowired
    public AuthServiceImpl(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    private final List<String> tokenStorage = new ArrayList<>();

    @Override
    public String login(Credential credential) {
        if (credential.getUsername().equals("nando") && credential.getPassword().equals("1234")) {
            String token = jwtUtil.generateToken("Whatever");
            tokenStorage.add(token);
            return token;
        } else {
            throw new UnauthorizedException("Invalid username or password");
        }
    }

    @Override
    public boolean validateToken(String token) {
        String existingToken = null;

        for (String t : tokenStorage) {
            if (t.equals(token)) {
                existingToken = t;
                break;
            }
        }

        if (existingToken == null) {
            throw new UnauthorizedException("Token is not exist");
        }

        if (jwtUtil.validateToken(existingToken)) {
            return true;
        } else {
            throw new UnauthorizedException("Token is invalid");
        }
    }

    @Override
    public boolean logout(String token) {
        return tokenStorage.remove(token);
    }
}
