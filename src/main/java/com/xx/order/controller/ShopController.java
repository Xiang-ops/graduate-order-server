package com.xx.order.controller;

import com.xx.order.model.MessageObject;
import com.xx.order.model.Shop;
import com.xx.order.service.ShopService;
import com.xx.order.utils.LocationUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class ShopController {
    @Autowired
    private ShopService shopService;
    @GetMapping("shop/detail")
    public Object selectAll(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        List<Shop> shopDetail = shopService.selectAll();
        double lat_a = Double.parseDouble(request.getParameter("latitude"));
        double lng_a = Double.parseDouble(request.getParameter("longitude"));
        jsonObject.put("shopDetail",shopDetail.get(0));

        //计算距离
        //获取两点之间的距离
        double lat_b = Double.parseDouble(shopDetail.get(0).getLatitude());
        double lng_b = Double.parseDouble(shopDetail.get(0).getLongitude());
        double distance = LocationUtils.getDistance(lng_a,lat_a,lng_b,lat_b);
        System.out.print(distance);
        jsonObject.put("distance",distance/1000);
        jsonObject.put("code",1);
        return jsonObject;
    }
    @GetMapping("shop/info")
    public Object getInfo(){
        List<Shop> shopDetail = shopService.selectAll();
        MessageObject msg = new MessageObject(shopDetail.get(0),1);
        return msg;
    }
    @PostMapping("submit/shop/info")
    public Object submitInfo(HttpServletRequest request){
        String shopName = request.getParameter("shopName");
        int id = Integer.parseInt(request.getParameter("id"));
        String shopIntro = request.getParameter("shopIntro");
        String longitude = request.getParameter("longitude");
        String latitude = request.getParameter("latitude");
        String address = request.getParameter("address");
        String timeStart = request.getParameter("timeStart");
        String timeEnd = request.getParameter("timeEnd");
        String monthSales = request.getParameter("monthSales");
        String linkPhone = request.getParameter("linkPhone");
        String shopPic = request.getParameter("shopPic");
        System.out.println(shopName);
        Shop shop = new Shop(id,shopName,shopIntro,longitude,latitude,address,timeStart,timeEnd,shopPic,monthSales,linkPhone);
        MessageObject msg = new MessageObject();
        boolean flag = shopService.updateShop(shop);
        if(flag){
            msg.setSuccess("成功");
        }else{
            msg.setError();
        }

        return msg;
    }
}
