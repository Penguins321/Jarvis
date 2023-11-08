package com.bairuihe.dcucuser.demos.service;

import com.bairuihe.dcucuser.demos.pojo.User;

import java.util.List;

/**
 * @Author ouyang    @Date 2023/11/2 0002
 * @Description
 * @menu
 */
public interface UserService {

    User getUser(String name);

    List<User> testExport();
}
