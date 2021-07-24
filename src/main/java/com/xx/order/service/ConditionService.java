package com.xx.order.service;

import com.xx.order.mapper.ConditionMapper;
import com.xx.order.model.Conditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConditionService {
    @Autowired
    private ConditionMapper conditionMapper;

    /**
     * 获取某菜品的所有规格
     */
    public List<Conditions>getGoodsCondition(Integer menuId){
        return conditionMapper.getGoodsCondition(menuId);
    }
    /**
     * 给某个菜品添加规格
     */
    public Boolean addCondition(int flagId, int menuId, String condition){
        return conditionMapper.addCondition(flagId, menuId, condition)>0;
    }
    /**
     * 删除某个规格
     */
    public boolean deleteCondition(int id){
        return conditionMapper.deleteCondition(id)>0;
    }
}
