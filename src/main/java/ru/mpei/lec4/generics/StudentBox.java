package ru.mpei.lec4.generics;

import ru.mpei.lec2.inheritance.Student;

public class StudentBox {

    private Student val;

    public StudentBox(Student val) {
        this.val = val;
    }

    public StudentBox (){
        this.val = null;
    }

    public boolean isEmpty(){
        return val == null;
    }

    public Student getVal() {
        return val;
    }

}
