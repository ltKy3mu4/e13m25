package ru.mpei.pr3;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Разработать класс MyExecutorService с методом:
 * TaskState execute (Runnable r, long delayMs) - выполняет заданную задачу через время с задержкой (delayMs)
 * и  внутренний класс TaskState, который определяет состояние задачи: Done, Canceld, Waiting
 * MyExecutorService хранит в себе заданное количество потоков (по дефолту 5), т.е. он может выполнить одновременно заданное количество методов execute
 */
public class MyExecutorService {


    private final int maxThreadCount;
    private AtomicInteger threadsCounter = new AtomicInteger(0);

    private Queue<RunnableWrapper> taskQueue = new ConcurrentLinkedQueue<>();


    public MyExecutorService(int threadCount) {
        this.maxThreadCount = threadCount;
        start();
    }

    public MyExecutorService() {
        this(5);
    }

    public TaskState execute(Runnable r, long delayMs) {
        taskQueue.add(new RunnableWrapper(r, delayMs));
        return new TaskState(State.Waiting);
    }

    private void start() {
        Thread enigneThread = new Thread(() -> {
            while (true) {
                while (threadsCounter.get() < maxThreadCount && !taskQueue.isEmpty()) {
                    RunnableWrapper t = taskQueue.poll();
                    threadsCounter.incrementAndGet();
                    new Thread(() -> {
                        try {
                            Thread.sleep(t.getTs());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        t.getR().run();
                        threadsCounter.decrementAndGet();
                    }).start();
                }
                sleep(5);
            }
        });
        enigneThread.start();
    }


    private void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Data
    @AllArgsConstructor
    public static class TaskState {
        private State state;
    }

    @Data
    @AllArgsConstructor
    private class RunnableWrapper {
        private Runnable r;
        private long ts;
    }
}
