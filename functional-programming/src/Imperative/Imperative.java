package Imperative;

import org.jetbrains.annotations.Contract;

import java.util.ArrayList;
import java.util.List;

public class Imperative {
    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("Vinícius", Gender.MALE),
                new Person("Gabriela", Gender.FEMALE),
                new Person("Arthur", Gender.MALE)
        );

        List<Person> females = new ArrayList<>();

        for (Person person : people) {
            if (Gender.FEMALE.equals(person.gender)) {
                females.add(person);
            }
        }

        for (Person female : females) {
            System.out.println(female);
        }

        // Using Stream API
        people.stream()
                .filter(person -> Gender.FEMALE.equals(person.gender))
                .forEach(System.out::println);

        List<Person> females2 = people.stream()
                .filter(person -> Gender.FEMALE.equals(person.gender))
                .toList();
        females2.forEach(System.out::println);
    }

    static class Person {
        private final String name;
        private final Gender gender;

        @Contract(pure = true)
        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "{\n" +
                    "    \"name\": \"" + name + "\",\n" +
                    "    \"gender\": \"" + gender + "\"\n" +
                    "}";
        }
    }

    enum Gender {
        MALE, FEMALE
    }
}