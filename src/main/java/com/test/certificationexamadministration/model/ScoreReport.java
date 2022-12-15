package com.test.certificationexamadministration.model;

import lombok.Data;

import java.util.Date;

@Data
public class ScoreReport {

    private Date attemptDate;
    private String username;
    private String moduleName;
    private String levelName;
    private Double score;

}
