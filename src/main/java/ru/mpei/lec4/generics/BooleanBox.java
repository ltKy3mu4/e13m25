package ru.mpei.lec4.generics;

public class BooleanBox {

    private Boolean val;

    public BooleanBox(Boolean val) {
        this.val = val;
    }

    public BooleanBox (){
        this.val = null;
    }

    public boolean isEmpty(){
        return val == null;
    }

    public Boolean getVal() {
        return val;
    }

}
