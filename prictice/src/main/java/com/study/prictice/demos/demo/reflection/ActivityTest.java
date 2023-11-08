package com.study.prictice.demos.demo.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author ouyang    @Date 2023/10/6 0006
 * @Description  通过反射获取TestReflection类得属性和方法
 * @menu
 */
public class ActivityTest {

   public static int a = 1;
   public static int b = 2;

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException, InstantiationException {

        // 方式一
        assert a == b;

        Class<?> aClass = Class.forName("com.study.prictice.demos.demo.reflection.TestReflection");

        TestReflection o = (TestReflection)aClass.newInstance();

        Method publicMethlod = aClass.getMethod("publicMethlod", String.class);


        publicMethlod.invoke(o,"  hhhh");

    }
}
