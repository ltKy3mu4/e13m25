package ru.mpei.lec4.generics;

import ru.mpei.lec2.Person;

public class PersonAnalyzer <T extends Person> {

    public boolean isSameAge(T p1, T p2) {
        return p1.getAge() == p2.getAge();
    }

}
