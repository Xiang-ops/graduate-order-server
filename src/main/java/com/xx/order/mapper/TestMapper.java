package com.xx.order.mapper;

import com.xx.order.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TestMapper {
    @Insert("insert into xxx")
    void insert();
    @Select("select count(*) from admin where name=#{username} and password=#{password}")
    int verifyPassword(String username,String password);
    @Select("select * from user")
    List<User> allUser();

}
