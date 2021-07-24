package com.xx.order.controller;

import com.xx.order.model.Coupon;
import com.xx.order.model.MessageObject;
import com.xx.order.model.UserCoupon;
import com.xx.order.service.CouponService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
public class CouponController {
    @Autowired
    private CouponService couponService;


    @GetMapping("get/all/coupon")
    public Object findAllCoupon(){
        JSONObject jsonObject = new JSONObject();
        String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        //couponType:0-->可领取
        //           -1-->已失效
        List<Coupon> allCoupon1 = couponService.findAllCoupon(0);
        for(Coupon x: allCoupon1){
            if(x.getEndDate().compareTo(currentDate)<0){
                boolean updateFlag = couponService.updateCouponStatus(x.getId());
                if(updateFlag)
                    continue;
                else{
                    jsonObject.put("code",0);
                    return jsonObject;
                }
            }
        }
        List<Coupon> allCoupon = couponService.findAllCoupon(0);
        jsonObject.put("code",1);
        jsonObject.put("allCoupon",allCoupon);
        return jsonObject;
    }
    @GetMapping("get/free/coupon")
    public Object findFreeCoupon(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        List<Coupon> freeCoupon1 = couponService.findCouponFree(0);
        //查找未失效的优惠券判断是否已经失效，再将最终未失效的优惠券传回前端
        for(Coupon x: freeCoupon1){
            if(x.getEndDate().compareTo(currentDate)<0){
                boolean updateFlag = couponService.updateCouponStatus(x.getId());
                if(updateFlag)
                    continue;
                else{
                    jsonObject.put("code",0);
                    return jsonObject;
                }
            }
        }
        List<Coupon> freeCoupon = couponService.findCouponFree(0);
        jsonObject.put("code",1);
        jsonObject.put("couponFree",freeCoupon);
        return jsonObject;
    }

    @GetMapping("get/user/coupon")
    public Object findUserCoupon(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        int userId = Integer.parseInt(request.getParameter("userId"));
        int couponType = Integer.parseInt(request.getParameter("couponType"));
        List<UserCoupon> userCoupon1 = couponService.findUserCoupon(userId,0);
        String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        for(UserCoupon x: userCoupon1){
            if(x.getEndDate().compareTo(currentDate)<0){
                boolean updateFlag = couponService.updateUserCouponStatus(x.getId());
                if(updateFlag)
                    continue;
                else{
                    jsonObject.put("code",0);
                    return jsonObject;
                }
            }
        }
        List<UserCoupon> userCoupon = couponService.findUserCoupon(userId,couponType);
        jsonObject.put("code",1);
        jsonObject.put("userCoupon",userCoupon);
        return jsonObject;
    }

    @GetMapping("fetch/coupon")
    public Object fetchCoupon(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        int userId = Integer.parseInt(request.getParameter("userId"));
        int couponId = Integer.parseInt(request.getParameter("id"));
        Coupon currentCoupon = couponService.findCurrentCoupon(couponId).get(0);
        UserCoupon userCoupon = new UserCoupon(currentCoupon.getId(),userId,currentCoupon.getHreshold(),currentCoupon.getSubPrice(),currentCoupon.getEndDate(),currentCoupon.getCouponType());
        boolean insertFlag = couponService.couponIfExist(couponId);
        if(insertFlag){
            jsonObject.put("code",-1);
            jsonObject.put("msg","已领取");
            return jsonObject;
        }
        boolean flag = couponService.addUserCoupon(userCoupon);
        System.out.println("couponId值");
        System.out.println(flag);
        if(flag){
            jsonObject.put("code",1);
        }else{
            jsonObject.put("code",0);
        }
        return jsonObject;
    }
    @GetMapping("get/use/coupon")
    public Object changeCoupon(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        int userId = Integer.parseInt(request.getParameter("userId"));
        int price = Integer.parseInt(request.getParameter("price"));
        List<UserCoupon> useCouponsList = couponService.findUseCoupons(userId,price);
        jsonObject.put("code",1);
        jsonObject.put("useCouponsList",useCouponsList);


        return jsonObject;
    }

    @GetMapping("get/user/coupon/num")
    public Object getCouponNum(HttpServletRequest request){
        int userId = Integer.parseInt(request.getParameter("userId"));
        int couponType = Integer.parseInt(request.getParameter("couponType"));
        System.out.println("userId");
        System.out.println(userId);
        System.out.println("couponType");
        System.out.println(couponType);
        MessageObject msg = new MessageObject();
        int num = couponService.findCouponNum(userId,couponType);
        if(num<0)
            msg.setError();
        else
            msg.setSuccess(num);
        return msg;
    }
    @PostMapping("add/coupon")
    public Object addCoupon(HttpServletRequest request){
        int hreshold = Integer.parseInt(request.getParameter("hreshold"));
        int subPrice = Integer.parseInt(request.getParameter("subPrice"));
        String endDate = request.getParameter("endDate");
        int point = Integer.parseInt(request.getParameter("point"));
        MessageObject msg = new MessageObject();
        boolean flag = couponService.addCoupon(hreshold,subPrice,endDate,point);
        if(flag)
            msg.setSuccess("成功");
        else
            msg.setError();

        return msg;
    }
    @GetMapping("delete/coupon")
    public Object deleteCoupon(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        MessageObject msg = new MessageObject();
        boolean flag = couponService.deleteCoupon(id);
        if(flag)
            msg.setSuccess("成功");
        else
            msg.setError();
        return msg;
    }
}
