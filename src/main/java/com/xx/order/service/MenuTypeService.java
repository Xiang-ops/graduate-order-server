package com.xx.order.service;

import com.xx.order.mapper.MenuTypeMapper;
import com.xx.order.model.MenuType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuTypeService {
    @Autowired
    private MenuTypeMapper menuTypeMapper;
    /**
     * 添加菜单类型
     */
    public boolean addMenuType(MenuType menuType){
        return menuTypeMapper.addMenuType(menuType)>0;
    }
    /**
     * 查看所有菜单类型
     */
    public List<MenuType> allMenuType(){
        return menuTypeMapper.allMenuType();
    }
    /**
     * 删除指定菜单类型
     */
    public boolean deleteMenuType(int id){
        return menuTypeMapper.deleteMenuType(id)>0;
    }

}
