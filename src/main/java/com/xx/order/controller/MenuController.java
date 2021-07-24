package com.xx.order.controller;

import com.alibaba.fastjson.JSONObject;
import com.xx.order.model.Menu;
import com.xx.order.model.MenuInOrder;
import com.xx.order.model.MessageObject;
import com.xx.order.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
public class MenuController {
    @Autowired
    private MenuService menuService;
    @Configuration
    public class MyPicConfig implements WebMvcConfigurer {
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/menuPic/**")
                    .addResourceLocations("file:F:/GraduateDesign/code/Order/menuPic/");
        }
    }

    @GetMapping("menu")
    public List<Menu> allMenu(){
        return menuService.allMenu();
    }
    @PostMapping("menu/add")
    public Object addMenu(HttpServletRequest req){
        JSONObject jsonObject = new JSONObject();
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        String introduction = req.getParameter("introduction");
        String picture = req.getParameter("picture");
        String mid = req.getParameter("mtype");
        String menuSize = req.getParameter("menuSize");
        String mtype = menuService.selectName(Integer.parseInt(mid));
        Menu menu = new Menu();
        menu.setName(name);
        menu.setPrice(price);
        menu.setIntroduction(introduction);
        menu.setPicture(picture);
        menu.setMtype(mtype);
        menu.setMenuSize(menuSize);
        menu.setMid(Integer.parseInt(mid));
        boolean flag = menuService.addMenu(menu);
        if(flag){
            jsonObject.put("code",1);
            jsonObject.put("msg","添加成功");
            return jsonObject;
        }
        jsonObject.put("code",0);
        jsonObject.put("msg","添加失败");
        return jsonObject;
    }
//    上传菜品图片
//

//    编辑菜品
    @PostMapping("menu/update")
    public Object updateMenuMsg(HttpServletRequest req){
        JSONObject jsonObject = new JSONObject();
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        String introduction = req.getParameter("introduction");
        String id = req.getParameter("id");
        String picture = req.getParameter("picture");
        String mid = req.getParameter("mtype");
        String mtype = menuService.selectName(Integer.parseInt(mid));
        String menuSize = req.getParameter("menuSize");
        int makeTime = Integer.parseInt(req.getParameter("makeTime"));
        Menu menu = new Menu(Integer.parseInt(id),name,price,picture,introduction,mtype,menuSize,Integer.parseInt(mid),makeTime);
        boolean flag = menuService.updateMenuMsg(menu);
        if(flag){
            jsonObject.put("code",1);
            jsonObject.put("msg","修改成功");
            return jsonObject;
        }
        jsonObject.put("code",0);
        jsonObject.put("msg","修改失败");
        return jsonObject;
    }
    @GetMapping("menu/delete")
    public Object deleteMenu(HttpServletRequest req){
        JSONObject jsonObject = new JSONObject();
        String id = req.getParameter("id");
        boolean flag = menuService.deleteMenu(Integer.parseInt(id));
        if(flag){
            jsonObject.put("code",1);
            jsonObject.put("msg","删除成功");
            return jsonObject;
        }
        jsonObject.put("code",0);
        jsonObject.put("msg","删除失败");
        return jsonObject;
    }
    @GetMapping("goodsById")
    public List<Menu>selectById(HttpServletRequest request){
        String mid = request.getParameter("mid");
        return menuService.selectById(Integer.parseInt(mid));
    }

    @GetMapping("update/menu/size")
    public Object updateSize(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        int menuSize = Integer.parseInt(request.getParameter("menuSize"));
        MessageObject msg = new MessageObject();
        boolean flag = menuService.updateSize(id,menuSize);
        if(flag){
            msg.setSuccess("成功");
        }else{
            msg.setError();
        }
        return msg;
    }


    /**
     * 添加订单中的菜品
     */
//    @PostMapping("order/menu/add")
//    public Object addMenuOrder(HttpServletRequest request){
//        JSONObject jsonObject = new JSONObject();
//        String orderId = request.getParameter("orderId");
//        String menuName = request.getParameter("menuName");
//        String price = request.getParameter("price");
//        String condition = request.getParameter("condition");
//        MenuInOrder menuInOrder = new MenuInOrder();
//        menuInOrder.setOrderId(Integer.parseInt(orderId));
//        menuInOrder.setMenuName(menuName);
//        menuInOrder.setPrice(price);
//        menuInOrder.setCondition(condition);
//        boolean flag = menuService.addMenuOrder(menuInOrder);
//        if(flag){
//            jsonObject.put("code",1);
//            jsonObject.put("msg","添加成功");
//            return jsonObject;
//        }
//        jsonObject.put("code",0);
//        jsonObject.put("msg","添加失败");
//        return jsonObject;
//    }
}
