package com.qltc.springqltc.models;

public class ResponseAjax {
    private String status;
    private String message;

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

    public ResponseAjax(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public ResponseAjax() {
    }

    @Override
    public String toString() {
        return "ResponseAjax{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
