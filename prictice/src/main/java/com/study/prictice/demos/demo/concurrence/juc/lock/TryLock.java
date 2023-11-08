package com.study.prictice.demos.demo.concurrence.juc.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author ouyang    @Date 2023/9/22
 * @Description
 * @menu
 */
public class TryLock {

    private static ReentrantLock lock = new ReentrantLock();

    class LockTest extends Thread {
        public LockTest(String name) {
            super(name);
        }

        @Override
        public void run() {
            try {
                System.out.println(this.getName() + "开始获取锁");
                if (lock.tryLock(2, TimeUnit.SECONDS)) {
                    System.out.println(this.getName() + "获取到锁");
                    lock.lock();
                    Thread.sleep(5000);
                } else {
                    System.out.println(this.getName() + "未获取锁");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (lock.isHeldByCurrentThread()) {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();


        TryLock tryLock = new TryLock();
        Thread t1 = new Thread(tryLock.new LockTest("t1"));
        Thread t2 = new Thread(tryLock.new LockTest("t2"));

        t1.start();
        t2.start();
    }
}
