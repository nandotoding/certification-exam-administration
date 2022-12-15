package com.test.certificationexamadministration.exception;

import lombok.Data;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
@Data
public class InvalidInputException extends RuntimeException {

    private String code = "X02";
    private String status = "INVALID";

    public InvalidInputException() {
        super("Invalid input");
    }

    public InvalidInputException(String message) {
        super(message);
    }

}
