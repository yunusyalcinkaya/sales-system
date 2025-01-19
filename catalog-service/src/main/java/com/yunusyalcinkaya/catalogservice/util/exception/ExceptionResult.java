package com.yunusyalcinkaya.catalogservice.util.exception;

import java.time.LocalDateTime;

public class ExceptionResult<T> {

    private final LocalDateTime timestamp;
    private final ReturnType returnType;
    private final T content;

    public ExceptionResult(ReturnType returnType, T content) {
        this.timestamp = LocalDateTime.now();
        this.returnType = returnType;
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public ReturnType getReturnType() {
        return returnType;
    }

    public T getContent() {
        return content;
    }
}
