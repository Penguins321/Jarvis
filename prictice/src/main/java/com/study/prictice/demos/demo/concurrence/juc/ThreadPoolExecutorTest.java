package com.study.prictice.demos.demo.concurrence.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author ouyang    @Date 2023/9/13
 * @Description
 * @menu
 */
@Slf4j
public class ThreadPoolExecutorTest {

    public static void main(String[] args) {

        java.util.concurrent.ThreadPoolExecutor threadPool =
                new java.util.concurrent.ThreadPoolExecutor(10,
                        20,
                        0L,
                        TimeUnit.SECONDS,
                        new ArrayBlockingQueue<Runnable>(10),
                        Executors.defaultThreadFactory(),
                        new ThreadPoolExecutor.AbortPolicy());



    }
}
