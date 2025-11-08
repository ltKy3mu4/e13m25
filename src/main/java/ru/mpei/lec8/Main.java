package ru.mpei.lec8;

import ru.mpei.lec2.Person;
import ru.mpei.lec7.impl.Sender;
import ru.mpei.lec7.impl.SenderContextHolder;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {
        Consumer<String> c = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        Consumer<String> c2 = (s) -> System.out.println(s);

        Supplier<String> s = new Supplier<String>() {
            @Override
            public String get() {
                return "Hello";
            }
        };

        Supplier<List<Sender>> s2 = () -> {
            return SenderContextHolder.senders;
        };

        Function<Double, Integer> roundF = new Function<Double, Integer>() {
            @Override
            public Integer apply(Double aDouble) {
                return (int) Math.round(aDouble);
            }
        };

        Function<Double, Integer> roundF2 = d -> (int) Math.round(d);

        List<Person> ps = List.of(
                new Person("Ivan", "Ivanov", 30, true),
                new Person("Petr", "Petrov", 40, true),
                new Person("Anna", "Sidorova", 35, false),
                new Person("Elena", "Ivanova", 28, false),
                new Person("Sergey", "Kuznetsov", 50, true),
                new Person("Elena", "Smirnova", 45, false),
                new Person("Ivan", "Sokolov", 46, true)
        );

        double avAge = ps.stream()
                .filter(p -> p.isMale())
                .filter(p -> p.getAge() < 45)
                .mapToDouble(p -> p.getAge())
                .average()
                .orElse(0.0);

        Optional<Person> p = ps.stream()
                .sorted((o1, o2) -> Integer.compare(o1.getAge(), o2.getAge()))
//                .map(e -> e.getLastName() + " " + e.getFirstName())
                .filter(o -> o.getFirstName().equals("Ivan"))
                .findAny();


        List<String> womenNames = ps.stream()
                .filter(e -> !e.isMale())
                .map(e -> e.getFirstName())
                .distinct()
                .toList();

        Map<String, List<Person>> persons = ps.stream().collect(Collectors.groupingBy(pe -> pe.getFirstName()));

        Map<Integer, Person> m = ps.stream().collect(Collectors.toMap(e -> e.getAge(), e -> e));

        System.out.println("Average age: " + avAge);


    }
}
