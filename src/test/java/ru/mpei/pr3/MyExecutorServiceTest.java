package ru.mpei.pr3;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

class MyExecutorServiceTest {


    @Test
    @SneakyThrows
    public void runOneTaskTest(){
        AtomicInteger ai = new AtomicInteger(0);

        MyExecutorService e = new MyExecutorService();
        e.execute(() -> System.out.println("hell_"+ai.incrementAndGet()), 200);

        Assertions.assertEquals(0, ai.get());
        Thread.sleep(230);
        Assertions.assertEquals(1, ai.get());
    }


    @Test
    @SneakyThrows
    public void runHighCountThreads(){
        AtomicInteger ai = new AtomicInteger(0);

        MyExecutorService e = new MyExecutorService();
        e.execute(() -> System.out.println("hell_"+ai.incrementAndGet()), 200);
        e.execute(() -> System.out.println("hell_"+ai.incrementAndGet()), 200);
        e.execute(() -> System.out.println("hell_"+ai.incrementAndGet()), 200);
        e.execute(() -> System.out.println("hell_"+ai.incrementAndGet()), 200);
        e.execute(() -> System.out.println("hell_"+ai.incrementAndGet()), 200);
        e.execute(() -> System.out.println("hell_"+ai.incrementAndGet()), 200);
        e.execute(() -> System.out.println("hell_"+ai.incrementAndGet()), 200);
        e.execute(() -> System.out.println("hell_"+ai.incrementAndGet()), 200);
        e.execute(() -> System.out.println("hell_"+ai.incrementAndGet()), 200);
        e.execute(() -> System.out.println("hell_"+ai.incrementAndGet()), 200);

        Assertions.assertEquals(0, ai.get());
        Thread.sleep(230);
        Assertions.assertEquals(5, ai.get());
        Thread.sleep(230);
        Assertions.assertEquals(10, ai.get());
    }

    @Test
    @SneakyThrows
    public void runThreads_1(){
        AtomicInteger ai = new AtomicInteger(0);

        MyExecutorService e = new MyExecutorService();
        e.execute(() -> System.out.println("hell_"+ai.incrementAndGet()), 200);
        e.execute(() -> System.out.println("hell_"+ai.incrementAndGet()), 200);
        e.execute(() -> System.out.println("hell_"+ai.incrementAndGet()), 200);
        e.execute(() -> System.out.println("hell_"+ai.incrementAndGet()), 200);
        e.execute(() -> System.out.println("hell_"+ai.incrementAndGet()), 200);
        Assertions.assertEquals(0, ai.get());
        Thread.sleep(230);
        Assertions.assertEquals(5, ai.get());
        e.execute(() -> System.out.println("hell_"+ai.incrementAndGet()), 200);
        e.execute(() -> System.out.println("hell_"+ai.incrementAndGet()), 200);
        e.execute(() -> System.out.println("hell_"+ai.incrementAndGet()), 200);
        e.execute(() -> System.out.println("hell_"+ai.incrementAndGet()), 200);
        e.execute(() -> System.out.println("hell_"+ai.incrementAndGet()), 200);

        Thread.sleep(230);
        Assertions.assertEquals(10, ai.get());
    }

    @Test
    @SneakyThrows
    public void runThreads_2(){
        AtomicInteger ai = new AtomicInteger(0);

        MyExecutorService e = new MyExecutorService();
        e.execute(() -> System.out.println("hell_"+ai.incrementAndGet()), 100);
        e.execute(() -> System.out.println("hell_"+ai.incrementAndGet()), 100);
        e.execute(() -> System.out.println("hell_"+ai.incrementAndGet()), 200);
        e.execute(() -> System.out.println("hell_"+ai.incrementAndGet()), 200);
        e.execute(() -> System.out.println("hell_"+ai.incrementAndGet()), 200);
        Assertions.assertEquals(0, ai.get());
        Thread.sleep(130);
        Assertions.assertEquals(2, ai.get());
        e.execute(() -> System.out.println("hell_"+ai.incrementAndGet()), 100);
        e.execute(() -> System.out.println("hell_"+ai.incrementAndGet()), 100);
        Thread.sleep(130);
        Assertions.assertEquals(7, ai.get());
    }

}