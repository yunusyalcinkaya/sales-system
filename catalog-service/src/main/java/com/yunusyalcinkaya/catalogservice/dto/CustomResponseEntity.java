package com.yunusyalcinkaya.catalogservice.dto;

import java.time.LocalDateTime;

public class CustomResponseEntity<T> {

    private String returnCode;
    private T content;
    private LocalDateTime timestamp;

    private final String SUCCESS_RETURN_CODE = "0";

    public CustomResponseEntity(String returnCode, T content) {
        this.returnCode = returnCode;
        this.content = content;
        timestamp = LocalDateTime.now();
    }

    public CustomResponseEntity(T content) {
        this.returnCode = SUCCESS_RETURN_CODE;
        this.content = content;
        timestamp = LocalDateTime.now();
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
