package com.test.certificationexamadministration.exception;

import lombok.Data;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
@Data
public class ParentEntityDeletionException extends RuntimeException {

    private String code = "X03";
    private String status = "FAILED";

    public ParentEntityDeletionException() {
        super("Cannot delete. The data is a parent that has child in parent-child relation");
    }

    public ParentEntityDeletionException(String message) {
        super(message);
    }

}
