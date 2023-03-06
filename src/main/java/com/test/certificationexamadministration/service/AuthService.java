package com.test.certificationexamadministration.service;

import com.test.certificationexamadministration.model.request.Credential;

public interface AuthService {
    public String login(Credential credential);
    public boolean validateToken(String token);
    public boolean logout(String token);
}
