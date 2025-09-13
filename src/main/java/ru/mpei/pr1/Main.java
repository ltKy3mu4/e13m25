package ru.mpei.pr1;

import java.util.Arrays;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        int[] arr = {10,2,7,4,8};
        int[] arr2 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int swap = arr[i];
                    arr[i] = arr[j];
                    arr[j] = swap;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
        String task = """
            Создать класс Person с полями имя и возраст.
            Создать массив из 5 экземпляров.
            Найти Человека с медианным возрастом и вывести его имя и возраст
        """;

        Person[] ps = new Person[5];
        ps[0] = new Person("jack", 82);
        ps[1] = new Person("jack", 82);
        ps[4] = new Person("nik", 22);
        ps[3] = new Person("mat", 4);
        ps[2] = new Person("kit", 75);

        for (int i = 0; i < ps.length; i++) {
            for (int j = i+1; j < ps.length; j++) {
                if (ps[i].getAge() < ps[j].getAge()) {
                    Person swap = ps[i];
                    ps[i] =  ps[j];
                    ps[j] = swap;
                }
            }
        }

        System.out.println(Arrays.toString(ps));
        System.out.println(ps[ps.length / 2]);

        Object o = new Object();
//        o.toString();
        Class<?> clazz = o.getClass();
//        Person p = ps[0];
        boolean eq = ps[0] == ps[1];
        boolean eq2 = ps[0].equals(ps[1]);
        System.out.println();
    }


}
