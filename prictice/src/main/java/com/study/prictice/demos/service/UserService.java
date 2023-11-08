package com.study.prictice.demos.service;

/**
 * @Author ouyang    @Date 2023/10/12 0012
 * @Description   AOP切面编程
 * @menu
 */

public interface UserService {
    /**
     * 插入一个用户
     */
    public void insertUser();
    /**
     * 更新一个用户
     */
    public void updateUser();
    /**
     * 删除一个用户
     */
    public void deleteUser();
    /**
     * 选择一个用户
     */
    public void selectUser();
}
