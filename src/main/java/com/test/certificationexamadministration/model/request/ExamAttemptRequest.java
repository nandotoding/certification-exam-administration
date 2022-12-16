package com.test.certificationexamadministration.model.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class ExamAttemptRequest {

    @NotBlank
    private String username;

    @NotBlank
    private String moduleCode;

    @NotNull
    private Date attemptDate;

}
