package com.study.prictice.demos.demo.concurrence.juc;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author ouyang    @Date 2023/9/21
 * @Description 原子类
 * @menu
 */
public class ThreadAutomicClass {

    static AtomicInteger stock = new AtomicInteger(10000);

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ThreadInnerClass threadInnerClass = new ThreadAutomicClass().new ThreadInnerClass();
        FutureTask<AtomicInteger> futureTask = new FutureTask<AtomicInteger>(threadInnerClass);

        ExecutorService executorService = Executors.newFixedThreadPool(8);
        for (int i = 0; i < 10000; i++) {
            executorService.execute(futureTask);
        }
        executorService.shutdown();
        // Thread thread = new Thread(futureTask);
        // thread.start();
        System.out.println("外部值" + stock);
        System.out.println("内部返回值" + futureTask.get());
    }

    class ThreadInnerClass implements Callable {

        // @Override
        // public void run() {
        //     if(stock.get()>0) {
        //         stock.decrementAndGet();
        //     }
        //     System.out.println("内部值"+stock);
        // }

        @Override
        public Object call() throws Exception {
            if (stock.get() > 0) {
                stock.decrementAndGet();
            }
            return stock;
        }
    }
}


