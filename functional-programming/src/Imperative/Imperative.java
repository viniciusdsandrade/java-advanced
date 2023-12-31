package Imperative;

import java.util.ArrayList;
import java.util.List;

public class Imperative {
    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("Vinícius", Gender.MALE),
                new Person("Gabriela", Gender.FEMALE),
                new Person("Arthur", Gender.MALE),
                new Person("Silvana", Gender.FEMALE),
                new Person("Siloede", Gender.MALE)
        );

        List<Person> females = new ArrayList<>();
        List<Person> males = new ArrayList<>();

        // Imperative approach
        for (Person person : people) {
            if (Gender.MALE.equals(person.gender)) {
                males.add(person);
            }
        }

        for (Person person : people) {
            if (Gender.FEMALE.equals(person.gender)) {
                females.add(person);
            }
        }

        females.forEach(System.out::println);
        males.forEach(System.out::println);
    }

    static class Person {
        private final String name;
        private final Gender gender;

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

    public enum Gender {
        MALE, FEMALE
    }
}