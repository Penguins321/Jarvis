package com.study.prictice.demos.demo.concurrence.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author ouyang    @Date 2023/9/13
 * @Description
 * @menu
 */
@Slf4j
public class ThreadPool {

    public void task(){
        log.info("正在使用桌子");
    }

    public static void main(String[] args) {


        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ExecutorService threadExecutor = Executors.newSingleThreadExecutor();
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

        try {
            executorService.execute(() -> {
            });
            System.out.println("正在使用桌子");

            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
        }catch (Exception e){
            log.info("error");
        }finally {
            executorService.shutdown();   // 等待所有的线程任务执行完毕关闭线程池
            executorService.shutdownNow();  //  只等待当前正在执行的线程，当前执行线程执行完就关闭线程池（等待的线程尚未执行） 10个请求进来执行了5个

            executorService.isTerminated();  // 判断线程是否执行完毕
        }
    }
}
