package com.study.prictice.demos.demo.concurrence.thread;

/**
 * @Author ouyang    @Date 2023/9/12
 * @Description  代码多线程复用
 * @menu
 */
public class ThreadGetState {

    public static synchronized void use(){
        System.out.println("开始占座");
        // 使用中
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("使用完以释放");
    }

    public static void main(String[] args) {

        Thread t1 = new Thread(()->{
            use();
        });

        Thread t2 = new Thread(()->{
            use();
        });

        t1.start();
        t2.start();
        System.out.println(t1.getState());
        System.out.println(t2.getState());

        // try {
        //     Thread.sleep(2000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        System.out.println(t2.getState());

    }
}
