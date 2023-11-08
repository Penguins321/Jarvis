package com.study.prictice.demos.algorithm;

/**
 * 调用单例类的方法
 */
public class SingletonModeTest {
    public static void main(String[] args) {

        // SingletonMode singletonMode = new SingletonMode().getSingletonMode();     // 爆错

        //获取唯一的实例化的对象，注意不要new，在单例里已经实例化过了
        SingletonMode getSingletonMode = SingletonMode.getSingletonMode();
    }
}
