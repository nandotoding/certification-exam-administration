package com.test.certificationexamadministration.model.request;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ScoreRequest {

    @NotBlank(message = "Attempt ID is required")
    private String attemptId;

    @NotNull(message = "Score is required")
    @Min(0)
    @Max(100)
    private Double score;

}
