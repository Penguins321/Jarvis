package com.study.prictice.demos.controller;

import com.study.prictice.demos.service.GetStudentService;
import com.study.prictice.demos.service.LearnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @PostConstruct   指定初始化方法
 * */
@RestController
@RequestMapping(value = "/student")
public class SelectStudent {

    // http:localhost:9999/student/get

    @Autowired
    private GetStudentService getStudent;

    @Autowired
    private LearnService learn;

    @RequestMapping(value = "get",method = RequestMethod.GET)
    public String getStudent(){
        return getStudent.getStudent();
    }

    public void test(){
        WebMvcProperties.Servlet servlet = new WebMvcProperties.Servlet();
    }


    @RequestMapping(value = "/learnStream",method = RequestMethod.GET)
    public List<String> learnStream(){
        List<String> strList = learn.learnStream();

        return strList;
    }


    // http:localhost:9999/student/learnTransaction
    // 学习事务
    @RequestMapping(value = "/learnTransaction",method = RequestMethod.GET)
    public String learnTransaction(){
        try {
            learn.learnTransation();
            // learn.learnTransation2();
            learn.learnTransation3();
        }catch (Exception e) {
            return "catch!!";
        }
        return "success";
    }

}
