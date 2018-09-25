package com.virtusa.workouts.springworkout.dto;

public class ErrorDto {
    private String errorCode;
    private String errorCodeKey;
    private String errorShortMessage;
    private String errorMessage;
    private Exception exception;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCodeKey() {
        return errorCodeKey;
    }

    public void setErrorCodeKey(String errorCodeKey) {
        this.errorCodeKey = errorCodeKey;
    }

    public String getErrorShortMessage() {
        return errorShortMessage;
    }

    public void setErrorShortMessage(String errorShortMessage) {
        this.errorShortMessage = errorShortMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
}
