package com.xx.order.mapper;

import com.xx.order.model.Shop;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ShopMapper {
    @Select("select * from shop")
    List<Shop> selectAll();
    @Update("update shop set shopName=#{shopName},shopIntro=#{shopIntro},longitude=#{longitude},latitude=#{latitude},address=#{address},timeStart=#{timeStart},timeEnd=#{timeEnd},shopPic=#{shopPic},monthSales=#{monthSales},linkPhone=#{linkPhone} where id=#{id}")
    int updateShop(Shop shop);
}
