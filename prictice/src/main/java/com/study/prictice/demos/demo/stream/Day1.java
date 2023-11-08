package com.study.prictice.demos.demo.stream;

import com.baidu.prictice.service.bean.po.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author ouyang    @Date 2023/4/6
 * @Description 流操作
 */
public class Day1 {

    @Test
    public void  main (){

        List<Person> personList = this.test();

        Map<Integer, List<Person>> collect = personList.stream().collect(Collectors.groupingBy(x->x.getSalary()));

        personList.stream().filter(x->x.getSalary()>8000).forEach(System.out::println);
        if (1==1){
            System.out.println(1);
        }

    }



    public List<Person> test(){
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, "male", "New York"));
        personList.add(new Person("Jack", 7000, "male", "Washington"));
        personList.add(new Person("Lily", 7800, "female", "Washington"));
        personList.add(new Person("Anni", 8200, "female", "New York"));
        personList.add(new Person("Owen", 9500, "male", "New York"));
        personList.add(new Person("Alisa", 7900, "female", "New York"));

        return personList;
    }

    @Test
    public void testsd(){
        String addressStr = "广东省中山市中山市京开城D区7#106-109号";
        if(addressStr.contains("#")){
            int i = addressStr.indexOf("#");
            String addressStr2 = new StringBuilder().append(addressStr.substring(0,i)).append(addressStr.substring(i+1,addressStr.length())).toString();
            System.out.println(addressStr2);

        }
    }
}
