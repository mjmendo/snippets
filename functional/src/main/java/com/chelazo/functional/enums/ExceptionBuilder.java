package com.chelazo.functional.enums;

import java.util.function.BiFunction;

public enum ExceptionBuilder implements BiFunction<String, Throwable, RuntimeException> {
    validationException((message, throwable) -> new IllegalArgumentException(message, throwable)),
    pipelineException((message, throwable) -> new IllegalStateException(message, throwable))
    ;

    private final BiFunction<String, Throwable, RuntimeException> func;

    ExceptionBuilder(BiFunction<String, Throwable, RuntimeException> func){
        this.func = func;
    }

    @Override
    public RuntimeException apply(String message, Throwable throwable) {
        return func.apply(message,throwable);
    }
}
