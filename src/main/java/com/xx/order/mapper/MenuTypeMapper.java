package com.xx.order.mapper;

import com.xx.order.model.MenuType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MenuTypeMapper {
    @Insert("insert into menuType(mtype,name) values(#{mtype},#{name})")
    int addMenuType(MenuType menuType);
    @Select("select * from menuType")
    List<MenuType> allMenuType();
    @Delete("delete from menuType where id=#{id}")
    int deleteMenuType(int id);
}
