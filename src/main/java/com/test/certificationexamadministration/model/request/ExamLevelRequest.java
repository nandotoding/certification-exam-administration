package com.test.certificationexamadministration.model.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ExamLevelRequest {

    @NotBlank(message = "Level Code is required")
    private String levelCode;

    @NotBlank(message = "Level Name is required")
    private String levelName;

}
