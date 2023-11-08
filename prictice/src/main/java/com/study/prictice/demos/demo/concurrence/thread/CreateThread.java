package com.study.prictice.demos.demo.concurrence.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @Author ouyang    @Date 2023/9/12
 * @Description
 * @menu
 */
@Slf4j
public class CreateThread {
    public static void main(String[] args) {


        Thread thread = new Thread(() -> {
            log.info("线程2执行");
            try {
                // Thread.sleep(1000);
                Thread.interrupted();  // 是否打断，同时清除打断标志
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.setPriority(Thread.MIN_PRIORITY);
        thread.start();
        thread.interrupt();
        // thread.isInterrupted();  是否打断，不清除打断标志
    }
}
