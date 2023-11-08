package com.study.prictice.demos.demo.javase.reflect;

import com.study.prictice.demos.pojo.StudentTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author ouyang    @Date 2023/10/14 0014
 * @Description  通过反射获取学生对象的属性和方法
 * @menu
 */
public class ReflectTest {

    /**
     * 获取反射对象的方法：
     * 1.类名
     * 2.实例化的对象
     * 3.类名.class()
     */

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        // 类名
        Class<?> aClass = Class.forName("com.baidu.prictice.service.bean.domain.StudentTest");

        // // 实例化的对象
        // StudentTest studentTest = new StudentTest();
        // Class<? extends StudentTest> aClass1 = studentTest.getClass();
        //
        // // 类名.class()
        // Class<StudentTest> studentTestClass = StudentTest.class;

        StudentTest studentTest1 = (StudentTest) aClass.newInstance();

        Method exam = aClass.getMethod("exam");


        // 执行代理方法之前执行
        System.out.println("执行代理方法之前执行");
        exam.invoke(studentTest1, null);
        // 执行代理方法之后执行
        System.out.println("执行代理方法之后执行");


    }
}
