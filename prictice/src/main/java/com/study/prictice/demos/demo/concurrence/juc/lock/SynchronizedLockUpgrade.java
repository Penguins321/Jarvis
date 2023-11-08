package com.study.prictice.demos.demo.concurrence.juc.lock;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Author ouyang    @Date 2023/9/22
 * @Description
 * @menu
 */
public class SynchronizedLockUpgrade {


    public static void main(String[] args) {

        // JVM启动时会有延迟，4秒内的为轻量级锁，4秒后才开启偏向锁
        try {
            Thread.sleep(4100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        class T{
            Integer age;
        }

        T t = new T();
        // 打印对象在堆内存中的布局以及锁状态
        // 无锁
        System.out.println(ClassLayout.parseInstance(t).toPrintable());

        // 偏向锁（无线程竞争）   JVM启动四秒内为轻量级锁，4秒后为偏向锁
        synchronized (t) {
            System.out.println(ClassLayout.parseInstance(t).toPrintable());
        }

        // 轻量级锁（两个不同的线程串行的获取锁）
        new Thread(()->{
            synchronized (t) {
                System.out.println(ClassLayout.parseInstance(t).toPrintable());
            }
        }).start();

    }



}
