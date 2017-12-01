package com.chelazo.functional.completablefuture;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;

public class BasicTest {

    @Test
    public void shouldCombine2Funtions() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture
                                                .supplyAsync(() -> "Hello")
                                                .thenApply(txt -> txt + " World.");

        assertEquals("Hello World.", future.get());
    }
}
