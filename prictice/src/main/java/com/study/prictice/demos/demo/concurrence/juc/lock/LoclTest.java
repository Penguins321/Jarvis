package com.study.prictice.demos.demo.concurrence.juc.lock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Author ouyang    @Date 2023/9/21
 * @Description
 * @menu
 */
public class LoclTest {

    public static AtomicInteger stock = new AtomicInteger(10);
    LoclTest lock = new LoclTest();

    public static void main(String[] args) {
        AtomicStampedReference<Integer> integerAtomicStampedReference = new AtomicStampedReference<Integer>(10000,0);

        Thread thread = new Thread(new LoclTest().new test());

    }

    class test implements Runnable {

        @Override
        public void run() {
            int oldValue;
            int newValue;

            do {
                oldValue = stock.get();
                newValue = oldValue + 1;

            } while (!stock.compareAndSet(oldValue, newValue));
        }
    }
}
