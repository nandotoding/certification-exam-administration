package com.test.certificationexamadministration.model.request;

import lombok.Data;

import java.util.Date;

@Data
public class ExamAttemptRequest {

    private String username;
    private String moduleCode;
    private Date attemptDate;

}
