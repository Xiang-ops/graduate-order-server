package com.xx.order.mapper;

import com.xx.order.model.MenuInOrder;
import com.xx.order.model.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper {
    @Select("select * from orders")
    List<Order> allOrder();
    @Insert("Insert into orders(date,price,number,clientName,menuTime,phone,userId,waitTime) values(#{date},#{price},#{number},#{clientName},#{menuTime},#{phone},#{userId},#{waitTime})")
    int addOrder(Order order);
    @Update("Update orders SET isCash=#{isCash} where id=#{id}")
    int updateOrderStatus(Integer isCash, Integer id);
    @Select("select * from orders where userId=#{userId}")
    List<Order> orderListByUser(Integer userId);
    @Select("select id from orders where number=#{number}")
    String selectId(String date);
//    @Delete("Delete from order where id=#{id}")
//    int deleteOrder(Integer id);

    @Insert("insert into menuinorder(menuName,price,menuSize,picture,number,orderNumber) values(#{menuName},#{price},#{menuSize},#{picture},#{number},#{orderNumber})")
    int addMenuOrder(MenuInOrder menuInOrder);
    @Update("Update orders SET menuName=#{menuName} where number=#{orderNumber}")
    int updateMenuOrderName(String menuName,String orderNumber);
    @Select("select * from menuinorder where orderNumber=#{orderNumber}")
    List<MenuInOrder>getMenuOrderList(String orderNumber);
    @Select("select waitTime from orders where isCash=0")
    List<String> selectOrdersTime();
}
