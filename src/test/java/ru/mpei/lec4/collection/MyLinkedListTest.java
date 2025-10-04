package ru.mpei.lec4.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

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

    @Test
    public void success_removeTest1(){
        List<String> myList = new MyLinkedList<>();
        myList.add("first");
        myList.add("second");
        myList.add("third");
        myList.add("forth");

        boolean result = myList.remove("first");
        Assertions.assertTrue(result);
    }

    @Test
    public void fail_removeTest1(){
        List<String> myList = new MyLinkedList<>();
        myList.add("first");
        myList.add("second");
        myList.add("third");
        myList.add("forth");

        boolean result = myList.remove("first1");
        Assertions.assertFalse(result);
    }

    @Test
    public void fail_removeTest2(){
        List<String> myList = new MyLinkedList<>();

        boolean result = myList.remove("first");
        Assertions.assertFalse(result);
    }

    @Test
    public void succ_containsTest1(){
        List<String> myList = new MyLinkedList<>();
        myList.add("first");
        myList.add("second");
        myList.add("third");
        myList.add("forth");

        boolean result = myList.contains("second");
        Assertions.assertTrue(result);
    }

    @Test
    public void succ_containsTest2(){
        List<String> myList = new MyLinkedList<>();
        myList.add("first");
        boolean result = myList.contains("first");
        Assertions.assertTrue(result);
    }

    @Test
    public void succ_containsTest3(){
        List<String> myList = new MyLinkedList<>();
        myList.add("first");
        myList.add("second");
        myList.add("third");
        myList.add("forth");

        boolean result = myList.contains("forth");
        Assertions.assertTrue(result);
    }


    @Test
    public void fail_containsTest1(){
        List<String> myList = new MyLinkedList<>();
        myList.add("first");
        myList.add("second");
        myList.add("third");
        myList.add("forth");

        boolean result = myList.remove("first1");
        Assertions.assertFalse(result);
    }

    @Test
    public void fail_containsTest2(){
        List<String> myList = new MyLinkedList<>();

        boolean result = myList.remove("first");
        Assertions.assertFalse(result);
    }

    @Test
    public void success_iteartionTest1(){
        List<String> myList = new MyLinkedList<>();
        myList.add("first");
        myList.add("second");
        myList.add("third");
        myList.add("forth");

        Iterator<String> it = myList.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        Assertions.assertThrows(NoSuchElementException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                it.next();
            }
        });
    }
}