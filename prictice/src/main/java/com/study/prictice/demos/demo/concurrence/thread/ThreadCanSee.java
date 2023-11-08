package com.study.prictice.demos.demo.concurrence.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @Author ouyang    @Date 2023/9/13
 * @Description 可见性
 * @menu
 */
@Slf4j
public class ThreadCanSee {
    static volatile Boolean always = true;

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            while (always) {
                System.out.println();
                synchronized (always){
                }
            }
        });
        thread.start();
        // for (int i = 0; i < 30; i++) {
        //     TimeUnit.SECONDS.sleep(1);
        //     log.info("每隔一秒跳动一次" + i);
        // }
        TimeUnit.SECONDS.sleep(2);
        always = false;
    }
}
