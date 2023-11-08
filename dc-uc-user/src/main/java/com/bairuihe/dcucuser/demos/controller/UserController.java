package com.bairuihe.dcucuser.demos.controller;

import com.bairuihe.dcucuser.demos.pojo.User;
import com.bairuihe.dcucuser.demos.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author ouyang    @Date 2023/11/2 0002
 * @Description
 * @menu
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;


    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public Object getUserInfo() {

        LocalDateTime startTime = LocalDateTime.now();
        User user = userService.getUser("ouyang");

        LocalDateTime endTime = LocalDateTime.now();
        Duration between = Duration.between(startTime, endTime);
        log.info("获取数据耗时：" + between.toMillis() + "毫秒");
        return user;

    }

    @RequestMapping(value = "/testExport",method = RequestMethod.GET)
    public Object testExport(){
        List<User> userList = userService.testExport();

        return new Object();
    }


}
