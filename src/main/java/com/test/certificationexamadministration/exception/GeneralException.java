package com.test.certificationexamadministration.exception;

import lombok.Data;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
@Data
public class GeneralException extends RuntimeException {

    private String code = "X00";
    private String status = "FAILED";

    public GeneralException() {
        super("Failed");
    }

    public GeneralException(String message) {
        super(message);
    }

}
