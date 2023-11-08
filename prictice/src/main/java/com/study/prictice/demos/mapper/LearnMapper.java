package com.study.prictice.demos.mapper;

import com.study.prictice.demos.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author ouyang    @Date 2023/6/13
 * @Description
 * @menu
 */
@Mapper
public interface LearnMapper {


    public List<String> getListData();

    void insert(Student student);
}
