package com.test.certificationexamadministration.exception;

import lombok.Getter;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
@Getter
public class UnauthorizedException extends RuntimeException {
    private final String code = "X04";
    private final String status = "Unauthorized";

    public UnauthorizedException() {
        super("Unauthorized");
    }

    public UnauthorizedException(String message) {
        super(message);
    }
}
