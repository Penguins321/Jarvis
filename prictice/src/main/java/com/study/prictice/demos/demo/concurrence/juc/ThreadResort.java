package com.study.prictice.demos.demo.concurrence.juc;

/**
 * @Author ouyang    @Date 2023/9/13
 * @Description 指令重排序
 * @menu
 */
public class ThreadResort {
    static ThreadResort threadResort;
    static Boolean isInit;

    public static void main(String[] args) throws InterruptedException {
        isInit = false;
        threadResort = null;

        for (int i = 0; i < 1000000; i++) {
            Thread thread1 = new Thread(() -> {
                synchronized (isInit) {
                    threadResort = new ThreadResort();
                    isInit = true;
                }
            });

            Thread thread2 = new Thread(() -> {
                synchronized (isInit) {
                    if (isInit) {
                        threadResort.doSomeThing();
                    }
                }
            });
            thread1.start();
            thread2.start();

            thread1.join();
            thread2.join();
        }
    }


    void doSomeThing() {
        System.out.println("doSomeThing");
    }
}
