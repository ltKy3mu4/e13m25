package ru.mpei.pr2;

import ru.mpei.lec2.inheritance.Student;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MapMain {

    public static void main(String[] args) {
        Map<String, Student> m = new HashMap<>();
        m.put("Ivan", new Student("Ivan", "Sidorov", 20, "e-13-24"));
        m.put("Kolyan", new Student("Kolyan", "Sidorov", 22, "e-13-24"));

        Student s = m.get("Ivan");
//        m.remove("Ivan");

        boolean res = m.containsKey("Kolyan");

        for (Map.Entry<String, Student> entr : m.entrySet()){
            System.out.println(entr.getKey());
            System.out.println(entr.getValue());
        }

        String uid = UUID.randomUUID().toString();
        System.out.println(uid);

    }

}
