package com.study.prictice.demos.demo.concurrence.thread;

import java.util.concurrent.*;

/**
 * @Author ouyang    @Date 2023/9/10
 * @Description
 * @menu
 */
public class ThreadPoolTest2 {
    public static void main(String[] args) {


        ExecutorService executorService = Executors.newCachedThreadPool();  // 无限制线程池

        ExecutorService executorService1 = Executors.newFixedThreadPool(16);  // 固定大小线程池

        ExecutorService threadExecutor = Executors.newSingleThreadExecutor();  // 创建单个线程得线程池


        // threadExecutor.execute(()->{
        //     for (int i = 0; i < 5; i++) {
        //         System.out.println(i);
        //     }
        // });

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(16,24,0L, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(5),new ThreadPoolExecutor.AbortPolicy());

        threadPoolExecutor.execute(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        });

        threadPoolExecutor.shutdown();
    }
}
