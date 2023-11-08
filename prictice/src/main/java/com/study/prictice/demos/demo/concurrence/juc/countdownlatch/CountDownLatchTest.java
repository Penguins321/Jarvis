package com.study.prictice.demos.demo.concurrence.juc.countdownlatch;

import org.apache.commons.collections4.ListUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author ouyang    @Date 2023/10/13 0013
 * @Description  多线程分组处理数据
 * @menu
 */
public class CountDownLatchTest {

    private static final int COUNT = 10;
    private static CountDownLatch countDownLatch = new CountDownLatch(COUNT);
    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(8,
            16,
            0L,
            TimeUnit.SECONDS,new ArrayBlockingQueue<>(30));


    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        initList(list);
        List<List<String>> partitionList = ListUtils.partition(list, COUNT);


        for (List s : partitionList) {
            threadPoolExecutor.execute(new Count());
        }
    }


    private static List initList(List list) {
        for (int i = 0; i < 100000; i++) {
            list.add(String.valueOf(i));
        }
        return list;
    }
}

class Count implements Runnable{

    @Override
    public void run() {

    }
}
