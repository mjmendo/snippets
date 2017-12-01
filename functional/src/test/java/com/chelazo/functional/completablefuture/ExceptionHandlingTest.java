package com.chelazo.functional.completablefuture;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;

public class ExceptionHandlingTest {

    @Test
    public void shouldHandleExceptions(){
        CompletableFuture.supplyAsync(()-> {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException("Error sleeping", e);
                    }
                    if (System.currentTimeMillis()%2==0) {
                        throw new RuntimeException("Even time...");     // 50% chance to fail
                    }
                    return "Hello World!";
                })
                .thenAcceptAsync(s-> {
                    System.out.println("Result: " + s);
                })
                .exceptionally(e-> {
                    System.err.println("Error greeting: " + e.getMessage());
                    return null;
                });
    }
}
