package com.study.prictice.demos.demo.concurrence.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author ouyang    @Date 2023/9/13
 * @Description
 * @menu
 */
@Slf4j
public class ThreadPoolSubmit {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Future<Integer> future = executorService.submit(() -> {
            log.info("执行");
            return 5;
        });

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
