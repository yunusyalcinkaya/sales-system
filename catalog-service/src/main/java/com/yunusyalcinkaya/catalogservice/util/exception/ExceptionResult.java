package com.yunusyalcinkaya.catalogservice.util.exception;

public class ExceptionResult<T> {

    private int httpStatusCode;
    private String errorCode;
    private T errorContent;
    private String path;

    public ExceptionResult(int httpStatusCode, String errorCode, T errorContent, String path) {
        this.httpStatusCode = httpStatusCode;
        this.errorCode = errorCode;
        this.errorContent = errorContent;
        this.path = path;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(int httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public T getErrorContent() {
        return errorContent;
    }

    public void setErrorContent(T errorContent) {
        this.errorContent = errorContent;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
