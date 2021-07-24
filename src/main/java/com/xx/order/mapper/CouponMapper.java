package com.xx.order.mapper;

import com.xx.order.model.Coupon;
import com.xx.order.model.Menu;
import com.xx.order.model.UserCoupon;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CouponMapper {
    @Select("select * from coupon where couponType=#{couponType} and point>0")
    List<Coupon> findAllCoupon(int couponType);
    @Select("select * from coupon where couponType=#{couponType} and point=0")
    List<Coupon> findCouponFree(int couponType);
    @Select("select * from usercoupon where userId=#{userId} and couponType=#{couponType}")
    List<UserCoupon> findUserCoupon(int userId, int couponType);
    @Select("select * from coupon where id=#{couponId}")
    List<Coupon> findCurrentCoupon(int couponId);
    @Select("select count(*) from usercoupon where couponId=#{couponId}")
    int couponIfExist(int couponId);
    @Insert("insert into usercoupon(couponId, userId, hreshold,subPrice,endDate,couponType) values(#{couponId}, #{userId}, #{hreshold},#{subPrice}, #{endDate}, #{couponType})")
    int addUserCoupon(UserCoupon userCoupon);
    @Update("update coupon SET couponType=-1 where id=#{id}")
    int updateCouponStatus(int id);
    @Update("update usercoupon SET couponType=-1 where id=#{id}")
    int updateUserCouponStatus(int id);
    @Select("select * from usercoupon where userId=#{userId} and hreshold<=#{price}")
    List<UserCoupon> findUseCoupons(int userId,int price);
    @Select("select count(*) from usercoupon where userId=#{userId} and couponType=#{couponType}")
    int findCouponNum(int userId,int couponType);
    @Insert("Insert into coupon(hreshold,subPrice,endDate,point) values(#{hreshold},#{subPrice},#{endDate},#{point})")
    int addCoupon(int hreshold,int subPrice,String endDate,int point);
    @Delete("delete from coupon where id=#{id}")
    int deleteCoupon(Integer id);
}
