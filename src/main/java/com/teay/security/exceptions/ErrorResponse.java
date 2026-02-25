package com.teay.security.exceptions;

import java.time.LocalDateTime;

public class ErrorResponse {
    private String message;
    private int status;
    private LocalDateTime dateTime;

    public ErrorResponse(String message, int status) {
        this.message = message;
        this.status = status;
        this.dateTime = LocalDateTime.now();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
