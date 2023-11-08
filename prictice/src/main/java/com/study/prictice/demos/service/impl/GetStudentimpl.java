package com.study.prictice.demos.service.impl;


import com.study.prictice.demos.constants.TestEnum;
import com.study.prictice.demos.constants.Weekday;
import com.study.prictice.demos.mapper.GetStudentMapper;
import com.study.prictice.demos.service.GetStudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.TimeZone;

@Service
public class GetStudentimpl extends Object implements GetStudentService {

    @Autowired
    public GetStudentMapper getStudentMapper;

    @Override
    public String getStudent() {
        String stu = getStudentMapper.getStudent();
        return stu;
    }

    @Test
    public void test2(){

        System.out.println(Weekday.valueOf("SUN"));
        System.out.println(Weekday.FRI.getValue());
        System.out.println(TestEnum.YEAR.SPRING);
    }


    @Test
    public void test(){

        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        StringBuilder dateStr = new StringBuilder().append(year).append(".").append(month).append(".").append(day);
        System.out.println(dateStr);
    }

    @Test
    public void test5() {
        String str = "000000" + 24;
        String code = str.substring(str.length()-7);
        System.out.println(code);
    }

}
