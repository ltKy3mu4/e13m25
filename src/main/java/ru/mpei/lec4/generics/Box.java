package ru.mpei.lec4.generics;

public class Box <Type>{

    private Type val;

    public Box(Type val) {
        this.val = val;
    }

    public Box() {
        this.val = null;
    }

    public Type getVal() {
        return val;
    }

    public boolean isEmpty() {
        return val == null;
    }

}
