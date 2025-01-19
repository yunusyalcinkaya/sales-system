package com.yunusyalcinkaya.catalogservice.util.exception.customexceptions;

public class AlreadyExistsException extends RuntimeException {

    public AlreadyExistsException(String message) {
        super(message);
    }
}
