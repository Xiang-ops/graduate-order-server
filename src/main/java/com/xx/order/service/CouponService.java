package com.xx.order.service;

import com.xx.order.mapper.CouponMapper;
import com.xx.order.model.Coupon;
import com.xx.order.model.UserCoupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponService {
    @Autowired
    private CouponMapper couponMapper;

    /**
     * 查找所有有效的优惠券（积分商城）
     */
    public List<Coupon> findAllCoupon(int couponType){
        return couponMapper.findAllCoupon(couponType);
    }
    /**
     * 查找可领取的优惠券
     */
    public List<Coupon> findCouponFree(int couponType){
        return couponMapper.findCouponFree(couponType);
    }
    /**
     * 查找用户的优惠券
     */
    public List<UserCoupon> findUserCoupon(int userId,int couponType){
        return couponMapper.findUserCoupon(userId,couponType);
    }
    /**
     * 根据ID查找优惠券
     */
    public List<Coupon> findCurrentCoupon(int couponId){
        return couponMapper.findCurrentCoupon(couponId);
    }
    /**
     * 查找用户是否已领取该优惠券
     */
    public Boolean couponIfExist(int couponId){
        return couponMapper.couponIfExist(couponId)>0;
    }
    /**
     * 用户领取优惠券
     */
    public Boolean addUserCoupon(UserCoupon userCoupon){
        return couponMapper.addUserCoupon(userCoupon)>0;
    }
    /**
     * 优惠券失效（积分商城）
     */
    public Boolean updateCouponStatus(int id){
        return couponMapper.updateCouponStatus(id)>0;
    }
    /**
     * 优惠券失效（我的优惠券）
     *
     */
    public Boolean updateUserCouponStatus(int id){
        return couponMapper.updateUserCouponStatus(id)>0;
    }
    /**
     * 查找用户可用优惠券
     */
    public List<UserCoupon> findUseCoupons(int userId,int price){
        return couponMapper.findUseCoupons(userId,price);
    }
    /**
     * 查找用户优惠券数目
     */
    public int findCouponNum(int userId,int couponType){
        return couponMapper.findCouponNum(userId, couponType);
    }
    /**
     *
     */
    public Boolean addCoupon(int hreshold,int subPrice,String endDate,int point){
        return couponMapper.addCoupon(hreshold, subPrice, endDate, point)>0;
    }
    /**
     *
     */
    public Boolean deleteCoupon(int id){
        return couponMapper.deleteCoupon(id)>0;
    }
}
