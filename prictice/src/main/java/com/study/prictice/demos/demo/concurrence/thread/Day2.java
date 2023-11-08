package com.study.prictice.demos.demo.concurrence.thread;

/**
 * @Author ouyang    @Date 2023/9/6
 * @Description
 * @menu
 */
public class Day2 {
    public static void main(String[] args) {

        Object o = new Object();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o){
                    for (int i = 1; i < 4; i++) {
                        System.out.println("线程1打印："+i);
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        o.notify();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o){
                    for (int i = 1; i < 4; i++) {
                        System.out.println("线程2打印:"+i);
                        o.notify();
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();


    }
}
