package com.study.prictice.demos.demo.concurrence.thread;

import java.util.concurrent.*;

/**
 * 线程池
 */
public class ThreadPoolTest {
    public static void main(String[] args) throws Exception {
        System.out.println("程序启动了");

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("主线程:------>" + i);
            }
        });
        // t1.start();

        //使用线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        service.execute(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("分支线程:------>" + i);
            }
        });

        service.shutdown();  //这个关键：可以关闭啦！


        /**
         * corePoolSize线程池的核心线程数
         * maximumPoolSize能容纳的最大线程数
         * keepAliveTime空闲线程存活时间
         * unit 存活的时间单位
         * workQueue 存放提交但未执行任务的队列
         * threadFactory 创建线程的工厂类
         * handler 等待队列满后的拒绝策略
         */
        //手动创建线程池
        // ExecutorService threadPool = new ThreadPoolExecutor(2, 5,
        //         1L, TimeUnit.SECONDS,
        //         Executors.defaultThreadFactory(),
        //         new ThreadPoolExecutor.AbortPolicy());
        //
        // threadPool.execute(() -> {
        //     for (int i = 0; i < 100; i++) {
        //         System.out.println("分支线程2---->" + i);
        //     }
        // });



    }
}


