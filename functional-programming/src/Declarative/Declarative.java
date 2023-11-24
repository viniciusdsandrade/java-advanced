package Declarative;

import java.util.List;

import static Declarative.Declarative.Gender.FEMALE;

public class Declarative {
    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("Vinícius", Gender.MALE),
                new Person("Gabriela", FEMALE),
                new Person("Arthur", Gender.MALE),
                new Person("Silvana", FEMALE),
                new Person("Siloede", Gender.MALE)
        );

        people.stream()
                .filter(person -> FEMALE.equals(person.gender)).forEach(System.out::println);

        List<Person> females = people.stream()
                .filter(person -> FEMALE.equals(person.gender))
                .toList();

        females.forEach(System.out::println);

        people.stream()
                .filter(person -> Gender.MALE.equals(person.gender))
                .forEach(System.out::println);

        List<Person> males = people.stream()
                .filter(person -> Gender.MALE.equals(person.gender))
                .toList();

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