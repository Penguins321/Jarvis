package com.study.prictice.demos.demo.concurrence.thread;

/**
 * @Author ouyang    @Date 2023/9/12
 * @Description
 * @menu
 */
public class AtomicIntegerTest {

    // 线程ab交替打印1到100
    public static void main(String[] args) {

        Object lock = new Object();

        new Thread(() -> {
            synchronized (lock) {
                for (int i = 1; i < 101; i++) {
                    System.out.println(Thread.currentThread().getName() + "===" + i);
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.notify();
                }
            }
        }).start();


        new Thread(() -> {
            synchronized (lock) {
                for (int i = 1; i < 101; i++) {
                    System.out.println(Thread.currentThread().getName() + "===" + i);
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


    }

}
