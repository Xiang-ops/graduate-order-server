package com.xx.order.controller;

import com.xx.order.model.MenuType;
import com.xx.order.service.MenuTypeService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin
@RestController
public class MenuTypeController {
@Autowired
    private MenuTypeService menuTypeService;

    @PostMapping("menutype/add")
    public Object addMenuType(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        MenuType menuType = new MenuType();
        String type = request.getParameter("mtype");
        String name = request.getParameter("name");
        menuType.setMtype(type);
        menuType.setName(name);
        boolean flag = menuTypeService.addMenuType(menuType);
        if(flag){
            jsonObject.put("code",1);
            jsonObject.put("msg","添加成功");
            return jsonObject;
        }
        jsonObject.put("code",0);
        jsonObject.put("msg","添加失败");
        return jsonObject;
    }
    @GetMapping("menutype")
    public List<MenuType> allMenuType(){
        return menuTypeService.allMenuType();
    }
    @GetMapping("menutype/delete")
    public Object deleteMenuType(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String id = request.getParameter("id");
        boolean flag = menuTypeService.deleteMenuType(Integer.parseInt(id));
        if(flag){
            jsonObject.put("code","1");
            jsonObject.put("msg","删除成功");
            return jsonObject;
        }
        jsonObject.put("code","0");
        jsonObject.put("msg","删除失败");
        return jsonObject;
    }
}
