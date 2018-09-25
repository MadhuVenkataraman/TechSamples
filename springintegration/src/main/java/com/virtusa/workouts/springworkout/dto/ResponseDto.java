package com.virtusa.workouts.springworkout.dto;

import java.util.ArrayList;
import java.util.List;

public class ResponseDto<T> {
    private String status;
    private String statusCode;
    private String message;
    private List<ErrorDto> errorDtoList = new ArrayList<ErrorDto>();
    private T payload;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ErrorDto> getErrorDtoList() {
        return errorDtoList;
    }

    public void setErrorDtoList(List<ErrorDto> errorDtoList) {
        this.errorDtoList = errorDtoList;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
}
