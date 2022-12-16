package com.test.certificationexamadministration.model.request;

import lombok.Data;

import javax.persistence.Column;

@Data
public class ExamLevelRequest {

    private String levelCode;
    private String levelName;

}
