package com.example.drawingapplication.service.client;

import com.google.gson.annotations.SerializedName;

public class ErrorResponse {

    private int httpStatus;

    @SerializedName("errorCode")
    private String errorCode;

    @SerializedName("message")
    private String message;

    @SerializedName("error")
    private String error;

    public ErrorResponse() {
    }

    public ErrorResponse(int httpStatus, String errorCode, String message) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.message = message;
    }

    public ErrorResponse(String errorCode, String error) {
        this.errorCode = errorCode;
        this.message = error;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
