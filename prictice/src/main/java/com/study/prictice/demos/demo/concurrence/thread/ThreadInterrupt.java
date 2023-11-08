package com.study.prictice.demos.demo.concurrence.thread;

/**
 * @Author ouyang    @Date 2023/9/12
 * @Description
 * @menu
 */
public class ThreadInterrupt {
    public static void main(String[] args) {

        Thread thread = new Thread(()->{

            while (true){
                System.out.println(Thread.currentThread().isInterrupted());
                if(Thread.interrupted()){
                    System.out.println(Thread.currentThread().isInterrupted() );
                    break;
                }
                System.out.println(
                        "线程保持活跃"
                );
            }
        });
        thread.start();
        thread.interrupt(); // 只是标记需要中断，实际不会中断

        // thread.stop();
    }
}
