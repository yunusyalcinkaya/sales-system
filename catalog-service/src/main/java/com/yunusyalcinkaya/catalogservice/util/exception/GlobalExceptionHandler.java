package com.yunusyalcinkaya.catalogservice.util.exception;

import com.yunusyalcinkaya.catalogservice.dto.CustomResponseEntity;
import com.yunusyalcinkaya.catalogservice.util.exception.customexceptions.BusinessException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final String FAILED_RETURN_CODE = "-1";

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CustomResponseEntity<ExceptionResult<Map<String, String>>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception, HttpServletRequest request) {
        Map<String, String> validationErrors = new HashMap<>();
        for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return new CustomResponseEntity<>(FAILED_RETURN_CODE, new ExceptionResult<>(HttpStatus.BAD_REQUEST.value(), FAILED_RETURN_CODE, validationErrors, request.getRequestURI()));
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public CustomResponseEntity<ExceptionResult<String>> handleDataIntegrityViolationException(DataIntegrityViolationException exception, HttpServletRequest request) {
        return new CustomResponseEntity<>(FAILED_RETURN_CODE, new ExceptionResult<>(HttpStatus.CONFLICT.value(), FAILED_RETURN_CODE, exception.getMessage(), request.getRequestURI()));
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public CustomResponseEntity<ExceptionResult<String>> handleBusinessException(BusinessException exception, HttpServletRequest request) {
        return new CustomResponseEntity<>(FAILED_RETURN_CODE, new ExceptionResult<>(HttpStatus.UNPROCESSABLE_ENTITY.value(), exception.getErrorCode(), exception.getMessage(), request.getRequestURI()));
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CustomResponseEntity<ExceptionResult<String>> handleRuntimeException(Exception exception, HttpServletRequest request) {
        return new CustomResponseEntity<>(FAILED_RETURN_CODE, new ExceptionResult<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), FAILED_RETURN_CODE, exception.getMessage(), request.getRequestURI()));
    }
}
