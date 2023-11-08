package com.bairuihe.dcucuser.demos.service.impl;

import com.bairuihe.dcucuser.demos.mappper.UserMapper;
import com.bairuihe.dcucuser.demos.pojo.User;
import com.bairuihe.dcucuser.demos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ouyang    @Date 2023/11/2 0002
 * @Description
 * @menu
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public User getUser(String name) {
        return userMapper.getUser(name);
    }

    @Override
    public List<User> testExport() {
        List<User> users = userMapper.selectAll();
        return users;
    }
}
