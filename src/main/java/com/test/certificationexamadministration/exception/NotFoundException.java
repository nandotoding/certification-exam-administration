package com.test.certificationexamadministration.exception;

import lombok.Data;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
@Data
public class NotFoundException extends RuntimeException {

    private final String code = "X01";
    private final String status = "NOT FOUND";

    public NotFoundException() {
        super("Data not found");
    }

    public NotFoundException(String message) {
        super(message);
    }

}
