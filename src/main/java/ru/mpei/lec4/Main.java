package ru.mpei.lec4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.mpei.lec4.generics.BooleanBox;
import ru.mpei.lec4.generics.Box;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static Logger logger = LoggerFactory.getLogger(ru.mpei.lec4.Main.class.getName());

    public static void main(String[] args) {
        BooleanBox box = new BooleanBox();

        if (box.isEmpty()){
            logger.info("Box is empty");
        } else {
            logger.info("Box is full : {}", box.getVal());
        }

        Box<String> b = new Box<>(new String("dsa"));
        Box<Integer> b2 = new Box<>(2);
        Box<Boolean> b4 = new Box<>();

        List<String> myList = new ArrayList<>();
        List<String> myList2 = new LinkedList<>();

    }

}
