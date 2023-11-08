package com.study.prictice.demos.demo.concurrence.juc;

import java.util.concurrent.TimeUnit;

/**
 * @Author ouyang    @Date 2023/9/17
 * @ 共享变量
 * @menu
 */
public class ThreadLocalTest {

    // ThreadLocal<Person> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {

        testThreadLocal();
    }

    private static void testThreadLocal() {
        InheritableThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

        threadLocal.set("test");

        new Thread(() -> {
            System.out.println(threadLocal.get());
            // threadLocal.remove();
        }).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("2" + threadLocal.get());
    }
}
