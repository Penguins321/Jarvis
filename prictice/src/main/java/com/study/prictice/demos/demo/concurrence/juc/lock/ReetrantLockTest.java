package com.study.prictice.demos.demo.concurrence.juc.lock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author ouyang    @Date 2023/9/22
 * @Description
 * @menu
 */
public class ReetrantLockTest {
    private static Integer stock = 10000;
    private static ReentrantLock lock = new ReentrantLock();


    class Test extends Thread {
        @Override
        public void run() {
            try {
                lock.lock();
                while (stock > 0) {
                    stock--;
                }
            } finally {
                // 判断当前锁是否在当前线程加锁状态中，不在加锁状态直接释放报错
                if (lock.isHeldByCurrentThread()) {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {

        ReetrantLockTest testThread = new ReetrantLockTest();
        ExecutorService threadPool = Executors.newCachedThreadPool();

        List<Object> objects = Collections.synchronizedList(new ArrayList<>());

        for (int i = 0; i < 100000; i++) {
            threadPool.execute(testThread.new Test());
            System.out.println(stock);
        }

    }
}
