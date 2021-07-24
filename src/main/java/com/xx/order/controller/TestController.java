package com.xx.order.controller;

import com.alibaba.fastjson.JSONObject;
import com.xx.order.model.User;
import com.xx.order.service.AdminService;
import com.xx.order.utils.LocationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@CrossOrigin
@RestController
public class TestController {
    @Autowired
    private AdminService adminService;
    @GetMapping("test")
    public String test(){
        return "test success";
    }
    @PostMapping("admin/login/status")
    public Object loginStatus(HttpServletRequest request, HttpSession session) {

        JSONObject jsonObject = new JSONObject();
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        int flag = adminService.verifyPassword(name,password);
        System.out.print(flag);
        if(flag>0){
            jsonObject.put("code",1);
            jsonObject.put("msg","登录成功");
            session.setAttribute("name",name);
            return jsonObject;
        }
        jsonObject.put("code",0);
        jsonObject.put("msg","登录失败，账号密码输入错误");
        return jsonObject;
    }
    @GetMapping("user")
    public Object selectUser(){
        Object users = adminService.allUser();
        System.out.print(users);
        return users;
    }
    @GetMapping("user/distance")
    public Object getDistance(HttpServletRequest request){
        String lat_a = request.getParameter("latitude");
        String lng_a = request.getParameter("longitude");
        JSONObject jsonObject = new JSONObject();
        //获取两点之间的距离
        double lat_b = 28.066031;
        double lng_b = 113.028325;
        double distance = LocationUtils.getDistance(112.98983,28.11426,lng_b,lat_b);
//        System.out.print(distance);
        if(distance>=(-1e-6)){
            jsonObject.put("code",1);
            jsonObject.put("distance",distance/1000);
            jsonObject.put("msg","计算成功");
        }else{
            jsonObject.put("code",0);
            jsonObject.put("msg","计算失败");
        }
        return jsonObject;
    }
}
