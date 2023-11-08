package com.study.prictice.demos.demo.concurrence.thread;

/**
 * @Author ouyang    @Date 2023/9/12
 * @Description
 * @menu
 */
public class ThreadJoin {
    static int value = 1;
    public static void main(String[] args) {

        Thread thread = new Thread(()->{
            value = 10;
        });
        thread.setDaemon(true);
        thread.start();
        // try {
        //     thread.join();
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        // try {
        //     TimeUnit.SECONDS.sleep(1);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        System.out.println("主线程done");
    }
}
