package ru.mpei.lec4.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

    @Test
    public void success_addTest1(){
        List<String> myList = new MyLinkedList<>();
        myList.add("first");
        myList.add("second");
        myList.add("third");
        myList.add("forth");

        Assertions.assertEquals("third", myList.get(2));
    }

    @Test
    public void fail_getNotExisted(){
        List<String> myList = new MyLinkedList<>();
        myList.add("first");
        myList.add("second");
        myList.add("third");
        myList.add("forth");

        var ex = new Executable() {
            @Override
            public void execute() throws Throwable {
                myList.get(10);
            }
        };
        Assertions.assertThrows(IndexOutOfBoundsException.class, ex);
    }


}