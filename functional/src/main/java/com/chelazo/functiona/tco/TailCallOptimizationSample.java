package com.chelazo.functiona.tco;

import java.util.stream.Stream;

public class TailCallOptimizationSample {

    public static TailCall squareAndPrint(int number, int max) {

        System.out.println(number * number);

        if (max > number) {

            return () -> squareAndPrint(number + 1, max);
        } else {

            return new TailCallTerminate();
        }
    }

    public static void main(String[] args) throws Exception {
        int max = Integer.parseInt("5");

        Stream.iterate(squareAndPrint(1, max), TailCall::get)
                .filter(TailCall::terminated)
                .findFirst();
    }
}

@FunctionalInterface
interface TailCall {
    TailCall  get();
    default boolean terminated() {return false;}
}

class TailCallTerminate implements TailCall {
    public TailCall get() {
        throw new Error("Dont call");
    }

    public boolean terminated() {
        return true;
    }
}
