package com.study.prictice.demos.demo.concurrence.juc;

import com.study.prictice.demos.pojo.Person;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.LongAdder;

/**
 * @Author ouyang    @Date 2023/9/21
 * @Description
 * @menu
 */
class AtomicTrue{
    public static AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) {
        test();
    }

    @Test
    public static void test(){
        atomicInteger.get();
        System.out.println(atomicInteger+"  1");

        atomicInteger.decrementAndGet();
        System.out.println(atomicInteger+"  2");

        atomicInteger.set(1000);
        System.out.println(atomicInteger+"  3");

        atomicInteger.addAndGet(1);
        System.out.println(atomicInteger+"  4");

        atomicInteger.compareAndSet(atomicInteger.get(),10);

        AtomicReference<Person> ai = new AtomicReference<>();

        AtomicIntegerFieldUpdater<Person> updater = AtomicIntegerFieldUpdater.newUpdater(Person.class,"age");

        LongAdder longAdder = new LongAdder();
        longAdder.longValue();
    }


}