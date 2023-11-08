package com.study.prictice.demos.demo.concurrence.juc.lock;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author ouyang    @Date 2023/9/21
 * @Description 生产者消费者模型
 * @menu
 */
public class ShareQueue {
    private static Integer queueSize = 10;
    private static volatile ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(queueSize);

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(20);
        threadPool.execute(new Consumer());

        for (int i = 0; i < 20; i++) {
            threadPool.execute(new Producter());
        }

    }

    // 生产者
    static class Producter extends Thread{
        @Override
        public void run() {
            while (true){
                synchronized (queue) {
                if(queue.size() < queueSize){
                    queue.add(1);
                    queue.notify();
                }else {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        queue.notify();
                    }
                }
                }
            }
        }
    }

    // 消费者
    static class Consumer extends Thread{
        @Override
        public void run() {
            // 保持一直活跃
            while (true){
                synchronized (queue) {
                    if(queue.isEmpty()){
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            queue.notify();
                        }
                    }else {
                        // 消费消息
                        Integer poll = queue.poll();
                        System.out.println(poll);
                        queue.notify();
                    }
                }
            }
        }
    }
}
