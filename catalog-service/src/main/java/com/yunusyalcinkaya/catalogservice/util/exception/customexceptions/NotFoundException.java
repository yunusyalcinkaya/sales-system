package com.yunusyalcinkaya.catalogservice.util.exception.customexceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}
