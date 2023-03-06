package com.test.certificationexamadministration.controller;

import com.test.certificationexamadministration.model.request.Credential;
import com.test.certificationexamadministration.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(UrlMappings.AUTH_URL)
public class AuthController {
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity doAuth(@RequestBody Credential credential) {
        String token = authService.login(credential);
        return ResponseEntity.ok(token);
    }

    @GetMapping("/token/validation")
    public ResponseEntity doTokenValidation(@RequestParam String token) {
        if (authService.validateToken(token)) {
            return ResponseEntity.ok("Token is valid");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token is invalid");
        }
    }

    @GetMapping("/logout")
    public ResponseEntity logout(@RequestParam String token) {
        if (authService.logout(token)) {
            return ResponseEntity.ok("Logout success");
        } else {
            return ResponseEntity.ok("Token not found");
        }
    }
}
