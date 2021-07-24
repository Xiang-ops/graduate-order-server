package com.xx.order.service;

import com.xx.order.mapper.OrderMapper;
import com.xx.order.model.MenuInOrder;
import com.xx.order.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;
    /**
     * 获取所有订单
     */
    public List<Order>allOrder(){
        return orderMapper.allOrder();
    }
    /**
     * 更新订单状态
     */
    public Boolean updateOrderStatus(Integer id, Integer isCash){
        return orderMapper.updateOrderStatus(id,isCash)>0;
    }
    /**
     * 根据用户ID获取订单
     */
    public List<Order>orderListByUser(Integer userId){
        return orderMapper.orderListByUser(userId);
    }
    /**
     * 添加订单
     */
    public Boolean addOrder(Order order){
        return orderMapper.addOrder(order)>0;
    }
    /**
     * 根据用户订单日期查找用户订单id
     */
    public String selectId(String number){
        return orderMapper.selectId(number);
    }
    /**
     * 添加订单中的菜品表格
     */
    public Boolean addMenuOrder(MenuInOrder menuInOrder){
        return orderMapper.addMenuOrder(menuInOrder)>0;
    }
    public Boolean updateMenuOrderName(String menuName,String orderNumber){
        return orderMapper.updateMenuOrderName(menuName,orderNumber)>0;
    }
    /**
     * 获取订单中的菜品列表
     */
    public List<MenuInOrder>getMenuOrderList(String orderNumber){
        return orderMapper.getMenuOrderList(orderNumber);
    }
    /**
     * 获取订单中的等待队列的时长
     */
    public List<String>selectOrdersTime(){
        return orderMapper.selectOrdersTime();
    }
}
