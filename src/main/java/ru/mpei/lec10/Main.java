package ru.mpei.lec10;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.*;
import java.util.concurrent.*;

@Slf4j
public class Main {

    public static String TEXT_FILENAME = "file.txt";

    @SneakyThrows
    public static void main(String[] args) {

//        List<String> a = Collections.synchronizedList(new ArrayList<>());
//        List<String> a = new CopyOnWriteArrayList();
//
//        var t1 = new Thread(() -> {
//            for (int i=0; i< 1_000;i ++){
//                a.add("t1"+i);
//            }
//        });
//
//        var t2 = new Thread(() -> {
//            for (int i=0; i< 1_000; i++){
//                a.add("t2"+i);
//            }
//        });
//
//        var t3 = new Thread(()->{
//            while (true) {
//                for (String v: a){
//                    System.out.println(v);
//                }
//            }
//        });
//
//        t1.start();
//        t2.start();
//        t3.start();
//
//        Thread.sleep(10000);
//
//        Map<String, String> m1 =Collections.synchronizedMap(new HashMap<>());
//        Map<String, String> m2 = new ConcurrentHashMap<>();

        List<String> a = new CopyOnWriteArrayList<>();

//        var t = new Thread(() -> {
//            int i =0;
//            while (true){
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                String val = i++ + "";
//                a.add(val);
//                log.info("added: {}", val);
//            }
//        });

//        t.start();
//        Thread cleaner = new Thread(() -> {
//            while (true) {
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                loadData(a);
//                a.clear();
//            }
//        });
//        cleaner.start();


        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);
//        executorService.schedule(() -> {
//            log.info("Task started");
//
//            loadData(a);
//            a.clear();
//            log.info("Task completed");
//            t.interrupt();
//        }, 1000, TimeUnit.MILLISECONDS);
        ScheduledFuture<?> helloFromExService = executorService.scheduleAtFixedRate(() -> log.info("Hello from ex service"), 1, 1, TimeUnit.SECONDS);

        ExecutorService s = Executors.newCachedThreadPool();

        s.execute(() -> log.info("Hello from ex service"));

    }

    @SneakyThrows
    public static void loadData(List<String> l){
        BufferedWriter br = new BufferedWriter(new FileWriter(TEXT_FILENAME));
        for (String str : l) {
            br.write(str + System.lineSeparator());
        }
        br.close();
    }

}
