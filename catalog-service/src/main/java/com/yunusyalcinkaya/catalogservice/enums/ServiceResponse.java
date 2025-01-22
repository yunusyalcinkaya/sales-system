package com.yunusyalcinkaya.catalogservice.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ServiceResponse {

    SUCCESS("0", "SUCCESS"),
    WARNING("1", "WARNING"),
    FAILED("-1", "FAILED");

    private final String code;
    private final String message;
}
