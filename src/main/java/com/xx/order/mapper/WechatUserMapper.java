package com.xx.order.mapper;

import com.xx.order.model.Sign;
import com.xx.order.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface WechatUserMapper {
    @Select("select count(*) from user where openid=#{openid}")
    int selectUser(String openid);
    @Insert("Insert into user(openid,username,avatar) values(#{openid},#{username},#{avatar})")
    int addUser(User user);
//    @Insert("Insert into user(phone) values (,#{phone}) where openid=#{openid}")
//    int insertUser(User user,String openid);
    @Select("select id from user where openid=#{openid}")
    String findId(String openid);
    @Select("select * from user where openid=#{openid}")
    List<User> findUserInfo(String openid);
    @Select("select gold from user where id = #{id}")
    int selectGold(int id);
    @Insert("update user set gold=#{gold} where id=#{id}")
    int updateGold(int gold,int id);
    @Insert("insert into userSign(userId,date) values(#{userId},#{date})")
    int insertSign(Sign sign);
    @Select("select date from userSign where userId=#{userId}")
    List<String> selectDate(int userId);
    @Select("select count(*) from userSign where userId=#{userId} and date=#{date}")
    int selectSign(int userId,String date);
    @Select("select * from user where id=#{userId}")
    List<User> selectUserInfo(int userId);
    @Update("update user set amount=#{amount} where id=#{id}")
    int updateAmount(int amount,int id);
    @Select("select amount from user where id=#{userId}")
    int findAmount(int userId);
    @Update("update user set isMember=#{flagId} where id=#{userId}")
    int updateLevel(int flagId,int userId);
}
