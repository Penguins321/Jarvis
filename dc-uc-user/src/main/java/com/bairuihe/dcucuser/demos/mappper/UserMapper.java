package com.bairuihe.dcucuser.demos.mappper;

import com.bairuihe.dcucuser.demos.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author ouyang    @Date 2023/11/2 0002
 * @Description
 * @menu
 */
@Mapper
public interface UserMapper {

   User getUser(@Param("name") String name);

    List<User> selectAll();
}
