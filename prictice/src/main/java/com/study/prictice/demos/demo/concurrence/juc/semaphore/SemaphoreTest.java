package com.study.prictice.demos.demo.concurrence.juc.semaphore;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Author ouyang    @Date 2023/10/13 0013
 * @Description Semaphore 信号量 控制线程数量
 * @menu
 */
public class SemaphoreTest {

    private static final int COUNT = 40;
    private static Executor executors = Executors.newFixedThreadPool(COUNT);
    // 信号量
    private static Semaphore semaphore = new Semaphore(10);

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            executors.execute(new SemaphoreTest.Task());
        }
    }

    static class Task
            implements Runnable {
        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + " 获取到信号量");
                Thread.sleep(1000);
                semaphore.release();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
