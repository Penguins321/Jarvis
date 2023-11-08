package com.study.prictice.demos.aspect;

import org.springframework.stereotype.Component;

/**
 * @Author ouyang    @Date 2023/10/12 0012
 * @Description
 * @menu
 */
@Component
public class TransitionAOP {
    public void openTransition(){
        System.out.println("开启事务");
    }
    public void closeTransition(){
        System.out.println("关闭事务");
    }
}
