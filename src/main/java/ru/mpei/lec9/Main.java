package ru.mpei.lec9;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
public class Main {

    public  static int counter;


    @SneakyThrows
    public static void main(String[] args) {
        AtomicInteger atomInt = new AtomicInteger();

//        AtomicReference<String> ref = new AtomicReference<>("hello");

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 20_000_000; i++){
//                int res = analyzeData();
//                incrementCounter(res);
                atomInt.incrementAndGet();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 20_000_000; i++){
//                int res = analyzeData();
//                incrementCounter(res);
                atomInt.incrementAndGet();
            }
        });

        t1.start();
        t2.start();

        Thread.sleep(3_000);
        log.info("{}",atomInt.get());

    }

    @SneakyThrows
    private static int analyzeData() {
        Thread.sleep(100);
        return 1;
    }

    public static synchronized void incrementCounter(int add){
        counter=counter + add;
    }
}
