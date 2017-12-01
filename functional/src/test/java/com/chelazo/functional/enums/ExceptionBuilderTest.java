package com.chelazo.functional.enums;

import org.junit.Test;

public class ExceptionBuilderTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowProviderExceptionType(){
        throw ExceptionBuilder.validationException.apply("error message", null);
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowProtocolExceptionType(){
        throw ExceptionBuilder.pipelineException.apply("error message", null);
    }
}