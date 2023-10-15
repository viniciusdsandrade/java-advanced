package Functional;

import org.jetbrains.annotations.Contract;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Functional {

    public static void main(String[] args) {
        int incremente = incrementByOne(7);
        System.out.println(incremente);

        int incremente2 = incrementByOneFunction.apply(incremente);
        System.out.println(incremente2);

        int numSum = incrementByOne(incremente2);
        System.out.println(numSum);

        int addAndMultiply = addBy1AndThenMultiplyBy10.apply(numSum);
        System.out.println(addAndMultiply);

        System.out.println(
                incrementByOneAndMultiplyBiFunction.apply(4,100)
        );
    }

    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;
    static Function<Integer, Integer> multiplyBy10Function = number -> number * 10;
    static Function<Integer, Integer> addBy1AndThenMultiplyBy10 = incrementByOneFunction.andThen(multiplyBy10Function);
    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
            (numberToIncrementByOne, numberToMultiplyBy) ->
                    (numberToIncrementByOne + 1) * numberToMultiplyBy;

    @Contract(pure = true)
    static int incrementByOne(int number) {
        return number + 1;
    }
}