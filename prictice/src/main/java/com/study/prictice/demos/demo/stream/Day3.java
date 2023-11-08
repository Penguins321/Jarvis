package com.study.prictice.demos.demo.stream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author ouyang    @Date 2023/10/5 0005
 * @Description
 * @menu
 */
public class Day3 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(6);
        list.add(4);

        // 中间操作
        // 排序
        // list.stream().sorted().forEach(t-> System.out.println(t));
        // 过滤
        // list.stream().filter(t->t!=1).forEach(t-> System.out.println(t));
        // 映射(运算)
        // list.stream().map(t->t*2).sorted().forEach(t-> System.out.println(t));

        // 终端操作
        // 收集
        // List<Integer> collect = list.stream().sorted().collect(Collectors.toList());
        // 计数
        // long count = list.stream().count();
        // 聚合
        // list.stream().reduce((t, u) -> t + u).ifPresent(t -> System.out.println(t));
        // 并行流
        // list.parallelStream().collect(Collectors.toList()).forEach(t -> System.out.println(t));


        /*=========================*/
        // 求平均值
        // list.stream().sorted().mapToDouble(t -> t * 1.0).average().ifPresent(t -> System.out.println(t));
        // list.stream().sorted().mapToInt(t -> t * 1).average().ifPresent(t-> System.out.println(t));

        // Class.forName()
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer i = iterator.next();
            if(i.equals(1)){
                iterator.remove();
            }
        }
        list.stream().sorted().forEach(t-> System.out.println(t));
    }
}
