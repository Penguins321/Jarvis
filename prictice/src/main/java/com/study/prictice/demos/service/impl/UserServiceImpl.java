package com.study.prictice.demos.service.impl;

import com.study.prictice.demos.aspect.TransitionAOP;
import com.study.prictice.demos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author ouyang    @Date 2023/10/12 0012
 * @Description
 * @menu
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TransitionAOP transitionAOP;

    private void openTransition() {
        transitionAOP.openTransition();
    }

    private void closeTransition() {
        transitionAOP.closeTransition();
    }

    @Override
    public void insertUser() {
        openTransition();
        System.out.println("插入一个用户");
        closeTransition();
    }
    @Override
    public void updateUser() {
        openTransition();
        System.out.println("更新一个用户");
        closeTransition();
    }
    @Override
    public void deleteUser() {
        openTransition();
        System.out.println("删除一个用户");
        closeTransition();
    }
    @Override
    public void selectUser() {
        openTransition();
        System.out.println("选择一个用户");
        closeTransition();
    }
}

