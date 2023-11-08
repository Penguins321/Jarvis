package com.study.prictice.demos.demo.concurrence.juc.lock;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author ouyang    @Date 2023/8/10
 * @Description
 * @menu
 */
public class FairLockTest {
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        ReentrantLock lock = new ReentrantLock();


    }

    public void test2() {

        ExecutorService executorService = Executors.newCachedThreadPool(new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return null;
            }
        });
    }

    // 冒泡
    public void bubbleSort() {
        Integer[] arr = {1, 4, 2, 7, 6, 3};
        Integer temp = null;

        for (int i = 1; i <= arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        Arrays.asList(arr).forEach(t-> System.out.println(t));
    }
}

class Singleton {
    private volatile static Singleton singleton;
    private Singleton(){};

    public static Singleton getSingleton(){
        if(singleton == null){
            synchronized(Singleton.class){
                if(singleton == null ){
                    Singleton singleton = new Singleton();
                }
            }
        }
        return singleton;
    }


}
