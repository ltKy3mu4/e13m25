package ru.mpei.lec2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.mpei.lec2.inheritance.Educatable;
import ru.mpei.lec2.inheritance.ParentPerson;
import ru.mpei.lec2.inheritance.Student;
import ru.mpei.lec2.inheritance.Teacher;

public class Lec2Main {

    static Logger log = LoggerFactory.getLogger(Lec2Main.class);

    public static void main(String[] args) {
        String s = "my String";
        log.trace("printed value of s {}", s);
        log.debug("printed value of s {}", s);
        log.info("printed value of s {}", s);
        log.warn("printed value of s {}", s);
        log.error("printed value of s {}", s);
//        System.out.println(s);

        String s2 = new String("my String");
        System.out.println(s2);

        String s3 = s + " " + s2;
        System.out.println(s3);

//        Person p1 = new Person();
//        p1.setFirstName("John");
//        p1.setLastName("Smith");
        Person p1 = new Person("John", "Smith");
        System.out.println(p1.getInfo());
        System.out.println(p1.isNeedToRetire());

        Person p2 = new Person();
        p2.setFirstName("Mary");
        p2.setLastName("Doe");
        System.out.println(p2.getInfo());

        Person p3 = new Person("Jack", "Sparrow", 68, true);
        System.out.println(p3.isNeedToRetire());

        Student st =  new Student("Jack", "Sparrow", 68, "e-13-25");
        System.out.println(st.printInfo());

        Teacher t1 = new Teacher("Janna", "Aguzarova", 100, "Plohaya muzyka");
        System.out.println(t1.printInfo());

//        Student[] students = new Student[2];
//        students[0]=st;
//        students[1] = t1;

        ParentPerson[] pp = new ParentPerson[2];
        pp[0] = st;
        pp[1] = t1;

        for (ParentPerson pp1 : pp) {
            System.out.println(pp1.printInfo());
        }

        Educatable[] eds = new  Educatable[2];
        eds[0] = st;
        eds[1] = t1;
        for (Educatable ed : eds) {
            System.out.println(ed.getUni());
        }
    }
}
