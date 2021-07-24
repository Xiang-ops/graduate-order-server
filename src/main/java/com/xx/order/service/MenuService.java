package com.xx.order.service;

import com.xx.order.mapper.MenuMapper;
import com.xx.order.model.Menu;
import com.xx.order.model.MenuInOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    private MenuMapper menuMapper;
//    private MenuInOrder
    /**
     * 获取所有的菜单
     */
    public List<Menu> allMenu(){
        return menuMapper.allMenu();
    }
    /**
     * 添加菜单
     */
    public Boolean addMenu(Menu menu){
        return menuMapper.addMenu(menu)>0;
    }
    /**
     * 上传图片
     */
    public Boolean updateMenuPic(Menu menu){
        return menuMapper.updateMenuPic(menu)>0;
    }
    /**
     * 更新信息
     */
    public Boolean updateMenuMsg(Menu menu){
        return menuMapper.updateMenuMsg(menu)>0;
    }
    /**
     * 删除信息
     */
    public Boolean deleteMenu(Integer id){
        return menuMapper.deleteMenu(id)>0;
    }
    /**
     * 根据id查找菜单类型名字
     */
    public String selectName(Integer id){
        return menuMapper.selectName(id);
    }
    /**
     * 根据菜单类型id查找菜品
     */
    public List<Menu> selectById(Integer mid){
        return menuMapper.selectById(mid);
    }
    /**
     * 更新菜品规格
     */
    public boolean updateSize(int id,int menuSize){ return menuMapper.updateSize(menuSize,id)>0; }

}
