package com.study.prictice.demos.demo.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Day0 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("小昭");
        list.add("殷离");
        list.add("张三");
        list.add("张三丰");

        List<String> listA = new ArrayList<>();
        for (String s : list) {
            if (s.startsWith("张")) {
                listA.add(s);
            }
        }

        List<String> listB = new ArrayList<>();
        for (String s : listA) {
            if (s.length() == 3) {
                listB.add(s);
            }
        }

        for (String s : listB) {
            System.out.println(s);
        }

        System.out.println("=============================");
        //流操作(顺序流)
        list.stream().filter(s -> s.startsWith("张")).filter(s -> s.length() == 3).forEach(s -> System.out.println(s));

        //(并行流)
        Stream<String> stringStream = list.parallelStream();
    }


    @Test
    public void test() {
        List<String> objects = new ArrayList<>();
        if(null != objects && objects.size() > 0){
            objects.add("");
        }
        System.out.println(objects);
    }


}
