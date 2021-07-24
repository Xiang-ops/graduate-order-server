package com.xx.order.controller;

import com.xx.order.model.Point;
import com.xx.order.service.PointService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

@CrossOrigin
@RestController
public class PointController {
    @Autowired
    private PointService pointService;

    @GetMapping("get/user/point")
    public Object findByUser(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        int userId = Integer.parseInt(request.getParameter("userId"));
        List<Point> pointObject = pointService.findAllByUser(userId);
        if(pointObject.size()>0){
            jsonObject.put("code",1);
            List<Object> pointsDetail = new LinkedList<>();
            LinkedHashMap<String,List<Point>>linked = new LinkedHashMap<>();
            for(Point k:pointObject){
                List<Point> pointArray = new LinkedList<Point>();
                JSONObject ob1 = new JSONObject();
                String date = k.getMonth();
                if(linked.get(date)==null)
                for(Point s:pointObject){
                    if(s.getMonth().equals(date)){
                        pointArray.add(s);
                    }
                }
                else continue;
                linked.put(date,pointArray);
                ob1.put("date",date);
                ob1.put("pointArray",pointArray);
                pointsDetail.add(ob1);
            }
            System.out.print(linked);
            jsonObject.put("pointsDetail",linked);
        }
        return jsonObject;
    }
    @GetMapping("add/point")
    /**
     * 增加积分
     * 1、签到加积分
     * 2、消费加积分
     */
    public Object insertPoint(HttpServletRequest request){
        int addPoint = Integer.parseInt(request.getParameter("addPoint"));
        int stepFlag = Integer.parseInt(request.getParameter("stepFlag"));
        int userId = Integer.parseInt(request.getParameter("userId"));
        JSONObject jsonObject = new JSONObject();
        String time = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        Calendar cal = Calendar.getInstance();
        int curYear = cal.get(Calendar.YEAR);
        int curMonth = cal.get(Calendar.MONTH)+1;
        String month = String.valueOf(curYear)+'年'+String.valueOf(curMonth)+'月';
        System.out.println(month);
        Point point = new Point();
        point.setAddPoint(addPoint);
        point.setUserId(userId);
        point.setMonth(month);
        point.setTime(time);
        point.setStepFlag(stepFlag);
        System.out.println("lalalala");
        System.out.print(point);
        boolean flag = pointService.addPoint(point);
        if(flag){
            jsonObject.put("code",1);
        }else{
            jsonObject.put("code",0);
        }
        return jsonObject;
    }
    @GetMapping("all/user/point")
    public Object getUserPoint(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        int userId = Integer.parseInt(request.getParameter("userId"));
        int allPoint  = pointService.getUserPoint(userId);
        if(allPoint>0){
            jsonObject.put("code",1);
            jsonObject.put("allPoint",allPoint);
        }else{
            jsonObject.put("code",0);
        }

        return jsonObject;
    }

}
