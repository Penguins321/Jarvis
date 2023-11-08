package com.study.prictice.demos.algorithm;

/**
 * 单例模式
 */
public class SingletonMode {
    //创建一个对象
    private static SingletonMode instance = new SingletonMode();

    //构造器私有化，这样外部对象就不能实例化它
    private SingletonMode(){}

    //提供public的方法用来给外部获取实例
    public static SingletonMode getSingletonMode(){
        return instance;
    }

     void showInstance(){
        System.out.println("单例模式");
    }
}

/**
 * 懒汉式，线程安全  效率低
 */
 class SingletonLaze{
    private static SingletonLaze instance;

    private SingletonLaze(){}

    public static synchronized SingletonLaze getInstance(){
        if (instance == null) {
            instance = new SingletonLaze();
        }
        return instance;
    }
}

/**
 * 饿汉式(不管是否存在实例都创建)：常用但容易产生垃圾对象
 * 没有加锁，效率高些
 * 类加载时就初始化，浪费内存
 */
class SingletonHungre{

    private static SingletonHungre instance = new SingletonHungre();

    private SingletonHungre(){}

    public static  SingletonHungre getInstance() {
        return instance;
    }
}

/**
 * 双重校验锁（DCL，即double-check-lock)
 * 较复杂，但是安全且高性能
 */
class SingletonDCL{

    private static SingletonDCL instance ;

    private SingletonDCL() {}

    public static SingletonDCL getInstance() {
        synchronized (SingletonDCL.class) {
            if (instance == null) {
                instance = new SingletonDCL();
            }
        }
        return instance;
    }

}