package com.yunusyalcinkaya.catalogservice.util.exception;

public enum ReturnType {

    SUCCESS("0"),
    WARNING("1"),
    ERROR("-1");

    private final String code;

    ReturnType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
