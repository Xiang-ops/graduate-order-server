package com.xx.order.service;

import com.xx.order.mapper.WechatUserMapper;
import com.xx.order.model.Sign;
import com.xx.order.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WechatUserService {
    @Autowired
    private WechatUserMapper weChatUser;
    public int selectUser(String openid){
        return weChatUser.selectUser(openid);
    }
    public int addUser(User user){
        return weChatUser.addUser(user);
    }
//    public boolean insertUser(User user, String openid){
//        return weChatUser.insertUser(user,openid)>0;
//    }
    /**
     * 根据用户的openid查找用户id
     */
    public String findId(String openid){
        return weChatUser.findId(openid);
    }
    /**
     * 根据用户的openid查找用户信息
     */
    public List<User> findUserInfo(String openid){
        return weChatUser.findUserInfo(openid);
    }
    /**
     * 用户获取目前积分
     */
    public int selectGold(int id){
        return weChatUser.selectGold(id);
    }
    /**
     * 用户签到获取积分
     */
    public Boolean updateGold(int gold,int id){
        return weChatUser.updateGold(gold, id)>0;
    }
    /**
     * 用户签到
     */
    public Boolean insertSign(Sign sign){
        return weChatUser.insertSign(sign)>0;
    }
    /**
     * 查找签到日期
     */
    public List<String> selectDate(int userId){
        return weChatUser.selectDate(userId);
    }
    /**
     * 查找用户今日是否已签到
     */
    public Boolean selectIfSign(int userId,String date){
        return weChatUser.selectSign(userId,date)>0;
    }
    /**
     * 根据id查找用户信息
     */
    public List<User> selectUserInfo(int userId){
        return weChatUser.selectUserInfo(userId);
    }
    /**
     * 修改用户金额
     */
    public boolean updateAmount(int amount,int userId){
        return weChatUser.updateAmount(amount, userId)>0;
    }
    /**
     * 查找用户金额
     */
    public int findAmount(int userId){
        return weChatUser.findAmount(userId);
    }
    /**
     * 修改用户等级
     */
    public boolean updateLevel(int flagId,int userId){
        return weChatUser.updateLevel(flagId,userId)>0;
    }
}
