package com.study.prictice.demos.demo.concurrence.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author ouyang    @Date 2023/9/13
 * @Description
 * @menu
 */
@Slf4j
public class ThreadCallable {
    public static void main(String[] args) {

        class Task implements Callable {
            @Override
            public Integer call() {
                return 5;
            }
        }

        FutureTask<Integer> futureTask = new FutureTask<Integer>(()->{
            return 5;
        });
        Thread thread = new Thread(futureTask);

        thread.start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
