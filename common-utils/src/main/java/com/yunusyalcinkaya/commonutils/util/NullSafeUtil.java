package com.yunusyalcinkaya.commonutils.util;

import com.yunusyalcinkaya.commonutils.exception.customexceptions.BusinessException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Objects;

public class NullSafeUtil {

    private NullSafeUtil() {}

    public static void checkIfNull(Object object, String errorCode, String errorMessage) {
        if (Objects.isNull(object))
            throw new BusinessException(errorCode, errorMessage);
    }

    public static void checkIfNull(Object object, ServiceResponse response) {
        if (Objects.isNull(object))
            throw new BusinessException(response.getCode(), response.getMessage());
    }

    public static void checkIfBlank(String object, String errorCode, String errorMessage) {
        if (StringUtils.isBlank(object))
            throw new BusinessException(errorCode, errorMessage);
    }

    public static void checkIfBlank(String object, ServiceResponse response) {
        if (StringUtils.isBlank(object))
            throw new BusinessException(response.getCode(), response.getMessage());
    }

    public static void checkIfEmpty(Collection<?> collection, String errorCode, String errorMessage) {
        if (CollectionUtils.isEmpty(collection))
            throw new BusinessException(errorCode, errorMessage);
    }

    public static void checkIfEmpty(Collection<?> collection, ServiceResponse response) {
        if (CollectionUtils.isEmpty(collection))
            throw new BusinessException(response.getCode(), response.getMessage());
    }
}
