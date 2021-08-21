package com.example.drawingapplication.service.client;

public class ErrorMessageResponse {

    private String error;
    private String error_description;
    private String hasError;
    private String decentMessage;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getError_description() {
        return error_description;
    }

    public void setError_description(String error_description) {
        this.error_description = error_description;
    }

    public String getHasError() {
        return hasError;
    }

    public void setHasError(String hasError) {
        this.hasError = hasError;
    }

    public String getDecentMessage() {
        return decentMessage;
    }

    public void setDecentMessage(String decentMessage) {
        this.decentMessage = decentMessage;
    }

}
