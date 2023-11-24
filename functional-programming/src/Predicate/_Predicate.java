package Predicate;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        System.out.println("Without predicate");
        System.out.println("0700000000 valid? " + isPhoneNumberValid("07000000000"));
        System.out.println("0900000000 valid? " + isPhoneNumberValid("09000000000"));

        System.out.println("With predicate");
        System.out.println("0900000000 valid? " + isPhoneNumberValidPredicate.test("07000000000"));
        System.out.println("0900000000 valid? " + isPhoneNumberValidPredicate.test("09000000000"));

        System.out.println("Is phone number valid and contains number 3? " +
                isPhoneNumberValidPredicate.and(containsNumber3).test("0700000000"));
    }

    static Boolean isPhoneNumberValid(String number) {
        return number.startsWith("07") && number.length() == 11;
    }

    static Predicate<String> isPhoneNumberValidPredicate = number ->
            number.startsWith("07") && number.length() == 11;

    static Predicate<String> containsNumber3 = number ->
            number.contains("3");

    static BiPredicate<String, String> containsNumber3And4 = (number, number2) ->
            number.contains("3") && number2.contains("4");
}
