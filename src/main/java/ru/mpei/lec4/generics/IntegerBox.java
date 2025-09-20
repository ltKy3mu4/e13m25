package ru.mpei.lec4.generics;

public class IntegerBox {

    private Integer val;

    public IntegerBox(Integer val) {
        this.val = val;
    }

    public IntegerBox (){
        this.val = null;
    }

    public boolean isEmpty(){
        return val == null;
    }

    public Integer getVal() {
        return val;
    }
}
