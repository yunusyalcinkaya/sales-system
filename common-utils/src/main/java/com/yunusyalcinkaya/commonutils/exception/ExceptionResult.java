package com.yunusyalcinkaya.commonutils.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ExceptionResult<T> {

    private int httpStatusCode;
    private String errorCode;
    private T errorContent;
    private String path;
}
