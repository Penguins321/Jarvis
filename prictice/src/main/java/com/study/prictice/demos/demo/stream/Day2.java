package com.study.prictice.demos.demo.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @Author ouyang    @Date 2023/8/27
 * @Description Stream流式操作
 * 过滤，映射，排序，聚合
 * 交集，并集，补集，差集
 * @menu stream
 */
public class Day2 {


    public static void main(String[] args) {
        // test();
        Object lock = new Object();
        new Thread(() -> {
            synchronized (lock) {
                for (int i = 1; i < 4; i++) {
                    System.out.println("线程1打印:" + i);
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("第一次这里是否执行");
                    lock.notify();
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (lock) {
                for (int i = 1; i < 4; i++) {
                    System.out.println("线程2打印：" + i);
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }


    public static void test() {
        // 将集合中的每个字符串转换为大写，并收集到新的列表中：
        // 统计集合中以字母"a"开头的字符串的数量：
        // 使用并行流来提高处理速度，筛选出长度小于等于5的字符串，并打印输出：
        // 使用 Stream 对集合中的整数求和：
        List<String> list = Arrays.asList("apple", "banana", "orange", "grapefruit", "kiwi");
        System.out.println(list);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        list.stream().parallel().filter(t -> t.length() <= 5).forEach(t -> System.out.println(t));
    }

}


// 线程交替打印123
class ThreadTest {


    public void test(Object lock) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    for (int i = 1; i < 4; i++) {
                        System.out.println("线程1打印:" + i);
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        lock.notify();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    for (int i = 1; i < 4; i++) {
                        System.out.println("线程2打印：" + i);
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        lock.notify();

                    }

                }
            }
        }).start();
    }


}
