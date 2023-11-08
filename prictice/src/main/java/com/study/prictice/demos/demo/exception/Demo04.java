package com.study.prictice.demos.demo.exception;

/**
 * @Author ouyang    @Date 2023/9/13
 * @Description
 * @menu
 */
//自定义异常：统一处理异常
//     抛出异常对象（throw），会使程序中止

public class Demo04{
    public static void main(String[] args){
        try{
            String str = null;
            System.out.println(str.equals(""));
            System.out.println("try即将结束");
        }catch(NullPointerException e){
            //抛出异常对象
            throw new MyException("Demo04 第15行的 str 可能出现 null ");
        }finally {
            System.out.println("finally");
        }
        System.out.println("程序即将结束");
    }
}
