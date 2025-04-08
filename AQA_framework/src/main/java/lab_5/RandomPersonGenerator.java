package lab_5;


import java.util.*;
import java.util.stream.Collectors;

public class RandomPersonGenerator {
    public static List<Person> generate(int count) {
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Person p = new Person();
            p.name = "Person" + i;
            p.isEmployed = new Random().nextBoolean();
            Address a = new Address();
            a.city = i % 2 == 0 ? "Boston" : "Chicago";
            a.street = "Street " + (100 + i);
            a.state = "State" + i;
            p.address = a;
            list.add(p);
        }
        return list;
    }

    public static void streamOps() {
        List<Person> people = generate(10);

        // Сортування
        List<Person> sorted = people.stream()
                .sorted(Comparator.comparing((Person p) -> p.name)
                        .thenComparing(p -> p.address.city))
                .collect(Collectors.toList());

        System.out.println("Sorted:");
        sorted.forEach(System.out::println);

        // Фільтрація
        List<Person> filtered = people.stream()
                .filter(p -> p.isEmployed && p.address.city.equals("Boston"))
                .collect(Collectors.toList());

        System.out.println("Filtered:");
        filtered.forEach(System.out::println);
    }
}
