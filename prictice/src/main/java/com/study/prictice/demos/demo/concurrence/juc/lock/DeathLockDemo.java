package com.study.prictice.demos.demo.concurrence.juc.lock;

/**
 * @Author ouyang    @Date 2023/8/9
 * @Description
 * @menu
 */
public class DeathLockDemo {

    private static String A = "A";
    private static String B = "B";

    public static void main(String[] args){
        new DeathLockDemo().deadLock();
    }

    private void deadLock(){

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (B){
                        System.out.println("AB");
                    }
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (A){
                        System.out.println("BA");
                    }
                }
            }
        });

        threadA.start();
        threadB.start();
    }




}
