package com.study.prictice.demos.service.impl;


import com.study.prictice.demos.mapper.LearnMapper;
import com.study.prictice.demos.pojo.Student;
import com.study.prictice.demos.service.LearnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author ouyang    @Date 2023/6/13
 * @Description 学习操作流实现类
 * @menu
 */

@Service
public class LearnImpl implements LearnService {


    @Autowired
    private LearnMapper learnMapper;

    /**
     * @param :
     * @return void
     * @author ouyang
     * @date 2023/6/13
     * @description 操作流的各种方法及练习
     * 流操作的几种情形：
     */
    @Override
    public List<String> learnStream() {

        //获取数据
        //获取list数据
        List<String> strList = learnMapper.getListData();

        return strList;
    }


    // 不回滚
    @Override
    @Transactional(rollbackFor = Exception.class, noRollbackFor = RuntimeException.class)
    public void learnTransation() {
        Student student = new Student();
        student.setName("test1");
        student.setHome("衡阳");
        learnMapper.insert(student);
        throw new RuntimeException();
    }

    // 回滚
    @Override
    @Transactional(rollbackFor = RuntimeException.class, noRollbackFor = Exception.class)
    public void learnTransation2() {
        Student student = new Student();
        student.setName("test2");
        student.setHome("四川");
        learnMapper.insert(student);
        throw new RuntimeException();
    }

    // ？？
    @Override
    @Transactional(rollbackFor = RuntimeException.class, noRollbackFor = Exception.class)
    public void learnTransation3() {
        Student student = new Student();
        student.setName("test3");
        student.setHome("广州");
        learnMapper.insert(student);
        throw new NullPointerException();
    }
}
