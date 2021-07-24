package com.xx.order.controller;

import com.xx.order.model.MenuInOrder;
import com.xx.order.model.Order;
import com.xx.order.model.Point;
import com.xx.order.service.OrderService;
import com.xx.order.utils.AddPointUtil;
import com.xx.order.utils.UuidUtil;
import org.json.JSONArray;
import net.sf.json.JSONObject;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("order")
    public List<Order>allOrder(){
        return orderService.allOrder();
    }
    @PostMapping("order/update/status")
    public Object updateOrderStatus(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String id = request.getParameter("id");
        String isCash = request.getParameter("isCash");
        boolean flag = orderService.updateOrderStatus(Integer.parseInt(isCash),Integer.parseInt(id));
        if(flag){
            jsonObject.put("code",1);
            jsonObject.put("msg","更新成功");
            return jsonObject;
        }
        jsonObject.put("code",0);
        jsonObject.put("msg","更新失败");
        return jsonObject;
    }

    @GetMapping("order/list")
    public List<Order> orderListByUser(HttpServletRequest request){
        String userId = request.getParameter("userId");
        return orderService.orderListByUser(Integer.parseInt(userId));
    }
    @PostMapping("order/add")
    public Object addOrder(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();

        String price = request.getParameter("price");
        int userPoint = (int) (Integer.parseInt(price)*0.5);
        Point myPoint = new Point();
        String clientName = request.getParameter("userName");
//        订单号
        String number = String.valueOf(System.currentTimeMillis());
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String userId = request.getParameter("userId");
        String menuTime = request.getParameter("menuTime");
        String phone = request.getParameter("phone");
        int makeTime = Integer.parseInt(request.getParameter("makeTime"));
        Order order = new Order();
        order.setNumber(number);
        order.setDate(date);
        order.setPrice(price);
        order.setClientName(clientName);
        order.setUserId(Integer.parseInt(userId));
        order.setMenuTime(menuTime);
        order.setPhone(phone);
        List<String> arrays = orderService.selectOrdersTime();
        System.out.print(arrays.size());
        System.out.print(arrays.get(arrays.size()-1));
        int waitTime = Integer.parseInt(arrays.get(arrays.size()-1))+makeTime;
        order.setWaitTime(waitTime);
        boolean flag = orderService.addOrder(order);
        if(flag){
            String orderId = orderService.selectId(number);
            if(orderId!=null){
                jsonObject.put("number",number);
                jsonObject.put("code",1);
                jsonObject.put("msg","添加成功");
                jsonObject.put("orderId","orderId");
                return jsonObject;
            }

        }
        jsonObject.put("code",0);
        jsonObject.put("msg","添加失败");
        return jsonObject;

    }

    @ResponseBody
    @PostMapping("order/menu/add")
    public Object addOrderMenu(@RequestParam("goodsList") String goodsList,@RequestParam("number") String orderNumber){
        JSONObject jsonObject = new JSONObject();
        int flag = 0;
        String menuName = "";
        try {
            JSONArray jsonArray = new JSONArray(goodsList);
            for (int i=0;i<jsonArray.length();i++){
                String name = (String) jsonArray.getJSONObject(i).get("name");
                String price = (String) jsonArray.getJSONObject(i).get("price");
                String picture = (String) jsonArray.getJSONObject(i).get("picture");
                String menuSize = (String) jsonArray.getJSONObject(i).get("menuSize");
                Integer number = (Integer) jsonArray.getJSONObject(i).get("number");
                MenuInOrder menuInOrder = new MenuInOrder(name,price,menuSize,picture,number,orderNumber);
                if(i==0){
                    menuName+=name;
                }else{
                    menuName=menuName+"+"+name;
                }

                boolean addFlag = orderService.addMenuOrder(menuInOrder);
                if(addFlag){
                    flag++;
                }
            }
            boolean updateFlag = orderService.updateMenuOrderName(menuName,orderNumber);

            if((flag == jsonArray.length())&&updateFlag){
                jsonObject.put("code",1);
                jsonObject.put("msg","添加成功");
            }else{
                jsonObject.put("code",0);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 获取订单中的菜品列表
     */
    @GetMapping("order/menu/list")
    public List<MenuInOrder> getMenuOrderList(HttpServletRequest request){
        String orderNumber = request.getParameter("orderNumber");
        return orderService.getMenuOrderList(orderNumber);

    }
}
