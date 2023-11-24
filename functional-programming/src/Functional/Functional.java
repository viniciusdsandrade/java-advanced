package Functional;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Functional {

    public static void main(String[] args) {
        // Function takes 1 argument and produces 1 result
        int somaUm = incrementByOne(7);
        System.out.println("somaUm: " + somaUm);

        int soma2 = incrementByOneFunction.apply(incrementByOne(7));
        System.out.println("SomaUmComProgramacaoFuncional: " + soma2);

        int numSum = incrementByOne(soma2);
        System.out.println(numSum);

        int addAndMultiply = addBy1AndThenMultiplyBy10.apply(numSum);
        System.out.println(addAndMultiply);

        //BiFunction
        System.out.println(
                incrementByOneAndMultiplyBiFunction.apply(4, 100)
        );

        System.out.println(
                incrementByOneAndMultiply(4, 100)
        );
    }

    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;
    static Function<Integer, Integer> multiplyBy10Function = number -> number * 10;
    static Function<Integer, Integer> addBy1AndThenMultiplyBy10 = incrementByOneFunction.andThen(multiplyBy10Function);
    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
            (numberToIncrementByOne, numberToMultiplyBy) ->
                    (numberToIncrementByOne + 1) * numberToMultiplyBy;

    static int incrementByOne(int number) {
        return number + 1;
    }

    static int incrementByOneAndMultiply(int number, int numToMultiplyBy) {
        return (number + 1) * numToMultiplyBy;
    }
}