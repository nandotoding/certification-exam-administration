package com.test.certificationexamadministration.model.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ExamModuleRequest {

    @NotBlank(message = "Module Code is required")
    private String moduleCode;

    @NotBlank(message = "Module Name is required")
    private String moduleName;

    @NotBlank(message = "Level Code is required")
    private String levelCode;

}
