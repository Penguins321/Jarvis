package com.bairuihe.dcucuser.demos.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.Data;

/**
 * @Author ouyang    @Date 2023/11/2 0002
 * @Description
 * @menu
 */
@Data
public class User {

    @ExcelProperty("序号")
    @ColumnWidth(20)
    private Integer id;

    @ExcelProperty("姓名")
    @ColumnWidth(20)
    private String name;

    @ExcelProperty("年龄")
    @ColumnWidth(20)
    private Integer age;

    @ExcelProperty("性别 0:未知 1:男 2:女" )
    @ColumnWidth(20)
    private Integer sex;
}
