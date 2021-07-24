package com.xx.order.mapper;

import com.xx.order.model.Menu;
import com.xx.order.model.MenuInOrder;
import com.xx.order.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MenuMapper {
    @Select("select * from menu")
    List<Menu> allMenu();
    @Insert("Insert into menu(name,price,introduction,picture,mtype,menuSize,mid) values(#{name},#{price},#{introduction},#{picture},#{mtype},#{menuSize},#{mid})")
    int addMenu(Menu menu);
    @Insert("Insert into menu(picture) values(#{picture})")
    int updateMenuPic(Menu menu);
    @Update("Update menu SET name=#{name},price=#{price},introduction=#{introduction},picture=#{picture},mtype=#{mtype},menuSize=#{menuSize},mid=#{mid} where id=#{id}")
    int updateMenuMsg(Menu menu);
    @Delete("Delete from menu where id=#{id}")
    int deleteMenu(Integer id);
    @Select("select name from menutype where id=#{id}")
    String selectName(Integer id);
    @Select("select * from menu where mid=#{mid}")
    List<Menu> selectById(Integer mid);
    @Update("update menu SET menuSize=#{menuSize} where id=#{id}")
    int updateSize(int menuSize,int id);

}
