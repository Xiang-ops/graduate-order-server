package com.xx.order.controller;

//import com.alibaba.fastjson.JSONObject;
import com.xx.order.model.Sign;
import com.xx.order.model.User;
import com.xx.order.service.WechatUserService;
import com.xx.order.utils.AddPointUtil;
import com.xx.order.utils.AesCbcUtil;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
public class WechatController {
    @Autowired
    private WechatUserService wechatUserService;
    @PostMapping("/user/login")
    public Object getWxUserOpenid(HttpServletRequest request){
        String username = request.getParameter("username");
        String avatar = request.getParameter("avatar");
        String code = request.getParameter("code");
        String AppID = "wx109f502f99e2249e";
        String AppSecret = "dda5bad27a8382fe581e3705aae523fc";
        User user = new User();
        user.setAvatar(avatar);
        user.setUsername(username);
        StringBuilder url = new StringBuilder("https://api.weixin.qq.com/sns/jscode2session?");
        url.append("appid=");
        url.append(AppID);
        url.append("&secret=");
        url.append(AppSecret);
        url.append("&js_code=");
        url.append(code);
        url.append("&grant_type=authorization_code");

        StringBuilder url2 = new StringBuilder("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&");
        url2.append("appid=");
        url2.append(AppID);
        url2.append("&secret=");
        url2.append(AppSecret);
        JSONObject jsonObject = new JSONObject();

        try {
            CloseableHttpClient client = HttpClientBuilder.create().build();//构建一个client
            HttpGet get = new HttpGet(url.toString());//构建一个get请求
            HttpResponse response = client.execute(get);//提交get请求
            HttpEntity result = response.getEntity();//拿到返回的HTTPResponse实体化
            String content = EntityUtils.toString(result);

            HttpGet get2 = new HttpGet(url2.toString());//获取token
            HttpResponse response2 = client.execute(get2);//提交获取token的get请求
            HttpEntity result2 = response2.getEntity();//拿到返回的HTTPResponse实体化
            String content2 = EntityUtils.toString(result2);
            JSONObject jsonObject2 = new JSONObject();
            jsonObject2 = JSONObject.fromObject(content2);
            String token = (String) jsonObject2.get("access_token");
//            System.out.print(token);
//            System.out.print(content);
            jsonObject = JSONObject.fromObject(content);
            String openid = (String) jsonObject.get("openid");
            user.setOpenid(openid);
//            String session_key = (String)jsonObject.get("session_key");
//            String results = AesCbcUtil.decrypt(encryptedData,session_key,iv,"UTF-8");

           int flag = wechatUserService.selectUser(openid);
           jsonObject.put("token",token);
           if(flag>0){
//               数据库中有数据，已注册
               jsonObject.put("code",100);

           }else {
//               数据库中无数据，重新注册
               int registryFlag = wechatUserService.addUser(user);
//               System.out.print(registryFlag);
               if(registryFlag>0){


                   jsonObject.put("code",10);
               }else {
                   jsonObject.put("code",0);
                   jsonObject.put("msg","注册失败");
               }
           }
            List<User> userInfo = wechatUserService.findUserInfo(openid);
            System.out.print(userInfo.get(0));
            String userId = wechatUserService.findId(openid);
            jsonObject.put("userInfo",userInfo.get(0));
            jsonObject.put("useId",Integer.parseInt(userId));
            return jsonObject;
        } catch (IOException e) {
            e.printStackTrace();
            jsonObject.put("msg","登录失败");
            jsonObject.put("code",0);
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("msg","解密失败");
            jsonObject.put("code",0);
        }
        return jsonObject;
    }
//    @PostMapping("insert/user")
//    public Object insertUser(HttpServletRequest request){
//        String username = request.getParameter("username");
//        String avatar = request.getParameter("avatar");
//        String phone = request.getParameter("phone");
//        String openid = request.getParameter("openid");
//        User user = new User();
//        user.setAvatar(avatar);
//        user.setUsername(username);
//        user.setPhone(phone);
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("code",0);
//        jsonObject.put("msg","登录失败");
//
//        if(flag){
//            jsonObject.put("code",1);
//            jsonObject.put("msg","登录成功");
//            return jsonObject;
//        }
//        return jsonObject;
//    }
    @GetMapping("score/sign")
    public Object userSign(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        Integer userId = Integer.parseInt(request.getParameter("userId"));
        String signDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        boolean ifSign = wechatUserService.selectIfSign(userId,signDate);
        if(ifSign){
            jsonObject.put("code",1);
            jsonObject.put("msg","今日已签到");
        }else{
            int gold = wechatUserService.selectGold(userId);
            gold = gold+5;
            boolean flag = wechatUserService.updateGold(gold,userId);
            Sign sign = new Sign();
            sign.setDate(signDate);
            sign.setUserId(userId);
            boolean signFlag = wechatUserService.insertSign(sign);
            if(flag&&signFlag){

                jsonObject.put("code",100);
                jsonObject.put("msg","签到成功");
                return jsonObject;
            }
            jsonObject.put("code",0);
            jsonObject.put("msg","签到失败");
        }

        return jsonObject;
    }
    @GetMapping("sign/log")
    public Object signLog(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        int userId = Integer.parseInt(request.getParameter("userId"));
        List<String> signDates = wechatUserService.selectDate(userId);
        System.out.print(signDates);
        jsonObject.put("signDates",signDates);

        jsonObject.put("code",1);
//        jsonObject.put("msg",)
        return jsonObject;

    }
    @GetMapping("get/user/info")
    public Object getGold(HttpServletRequest request){
        String userId = request.getParameter("userId");
        JSONObject jsonObject = new JSONObject();
        List<User> userApiInfos = wechatUserService.selectUserInfo(Integer.parseInt(userId));
        if(userApiInfos.size()>0){
            jsonObject.put("code",1);
            jsonObject.put("userApiInfos",userApiInfos);
        }else{
            jsonObject.put("code",0);
        }
        return jsonObject;
    }
    @GetMapping("update/amount")
    public Object updateAmount(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        int userId = Integer.parseInt(request.getParameter("userId"));
        int addAmount = Integer.parseInt(request.getParameter("amount"));
        int curAmount = wechatUserService.findAmount(userId);
        System.out.println(curAmount);
        int amount = curAmount+addAmount;
        boolean flag = wechatUserService.updateAmount(amount,userId);
        System.out.print(flag);
        if(flag){
            jsonObject.put("code",1);
            jsonObject.put("amount",amount);

        }else{
            jsonObject.put("code",0);
        }
        return jsonObject;
    }
    @GetMapping("get/user/amount")
    public Object getUserAmount(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        int userId = Integer.parseInt(request.getParameter("userId"));
        int amount = wechatUserService.findAmount(userId);
        jsonObject.put("code",1);
        jsonObject.put("amount",amount);
        return jsonObject;
    }
    @GetMapping("update/user/level")
    public Object updateUserLevel(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        int userId = Integer.parseInt(request.getParameter("userId"));
        int flagId = Integer.parseInt(request.getParameter("flagId"));
        boolean ifFlag = wechatUserService.updateLevel(flagId,userId);
        if(ifFlag){
            jsonObject.put("code",1);
        }else{
            jsonObject.put("code",0);
        }
        return jsonObject;
    }
}
