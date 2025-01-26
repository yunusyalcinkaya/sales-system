package com.yunusyalcinkaya.commonutils.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CustomResponseEntity<T> {

    private String returnCode;
    private T content;
    private LocalDateTime timestamp;

    private static final String SUCCESS_RETURN_CODE = "0";

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
}
