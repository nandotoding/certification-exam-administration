package com.test.certificationexamadministration.model.response;

import lombok.Data;

@Data
public class SuccessResponse<T> extends CommonResponse {

    T data;

    public SuccessResponse(String status, String message, T data) {
        super.setCode("00");
        super.setMessage(message);
        super.setStatus(status);
        this.data = data;
    }

}
