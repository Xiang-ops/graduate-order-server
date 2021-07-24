package com.xx.order.service;


import com.xx.order.mapper.ShopMapper;
import com.xx.order.model.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {
    @Autowired
    private ShopMapper shopMapper;
    /**
     * 获取用户信息
     */
    public List<Shop> selectAll(){
        return shopMapper.selectAll();
    }
    /**
     * 修改商家信息
     */
    public boolean updateShop(Shop shop){
        return shopMapper.updateShop(shop)>0;
    }
}
