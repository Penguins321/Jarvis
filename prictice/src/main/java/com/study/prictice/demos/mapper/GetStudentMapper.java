package com.study.prictice.demos.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GetStudentMapper {

    /**
     * 查询所有学生
     * @return
     */
    String getStudent();
}
