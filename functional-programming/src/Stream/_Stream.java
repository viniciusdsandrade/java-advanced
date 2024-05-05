package Stream;

import java.util.List;
import java.util.Objects;

public class _Stream {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", 20, Gender.MALE),
                new Person("Maria", 24, Gender.FEMALE),
                new Person("Aisha", 31, Gender.FEMALE),
                new Person("Alex", 41, Gender.MALE),
                new Person("Alice", 25, Gender.MALE)
        );

        System.out.println("Pessoas: ");
        people.forEach(System.out::println);

        System.out.println("Rapazes");
        List<Person> males = people.stream()
                .filter(person -> person.gender().equals(Gender.MALE))
                .toList();
        males.forEach(System.out::println);

        double average_male_age_stream = people.stream()
                .filter(person -> person.gender().equals(Gender.MALE))
                .mapToInt(Person::age)
                .average().orElseThrow();
        System.out.println("Media de idade masculina: " + average_male_age_stream);

        double average_male_age_function = calculateAverageMaleAge(people);
        System.out.println("Media de idade masculina: " + average_male_age_function);
    }

    public static double calculateAverageMaleAge(List<Person> people) {
        int sumOfAges = 0;
        int maleCount = 0;

        for (Person person : people) {
            if (person.gender().equals(Gender.MALE)) {
                sumOfAges += person.age();
                maleCount++;
            }
        }

        if (maleCount == 0) throw new ArithmeticException("Divisão por zero");

        return (double) sumOfAges / maleCount;
    }

    public record Person(String name, int age, Gender gender) {

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null) return false;
            if (this.getClass() != o.getClass()) return false;

            Person that = (Person) o;

            return Objects.equals(this.name, that.name) &&
                    Objects.equals(this.age, that.age) &&
                    Objects.equals(this.gender, that.gender);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    "age='" + age + '\'' +
                    "gender'" + gender + '\'' +
                    '}';
        }
    }

    enum Gender {
        MALE,
        FEMALE
    }
}
