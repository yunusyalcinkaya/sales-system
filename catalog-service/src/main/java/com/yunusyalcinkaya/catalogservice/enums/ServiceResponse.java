package com.yunusyalcinkaya.catalogservice.enums;

public enum ServiceResponse {

    SUCCESS("0", "SUCCESS"),
    WARNING("1", "WARNING"),
    FAILED("-1", "FAILED");

    private final String code;
    private final String message;

    ServiceResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
