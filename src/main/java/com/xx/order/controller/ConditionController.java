package com.xx.order.controller;


import com.xx.order.model.Conditions;
import com.xx.order.model.MessageObject;
import com.xx.order.service.ConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin
@RestController
public class ConditionController {
    @Autowired
    private ConditionService conditionService;

    @GetMapping("goods/conditions")
    public List<Conditions>getGoodsCondition(HttpServletRequest req){
        String menuId = req.getParameter("goodsId");
        return conditionService.getGoodsCondition(Integer.parseInt(menuId));

    }
    @GetMapping("add/menu/condition")
    public Object addCondition(HttpServletRequest request){
        MessageObject msg = new MessageObject();
        int flagId = Integer.parseInt(request.getParameter("flagId"));
        int menuId = Integer.parseInt(request.getParameter("menuId"));
        String condition = request.getParameter("condition");
        System.out.println(condition);
        boolean flag = conditionService.addCondition(flagId,menuId,condition);
        if(flag)
            msg.setSuccess("添加成功");
        else
            msg.setError();
        return msg;
    }
    @GetMapping("delete/conditions")
    public Object deleteConditions(HttpServletRequest request){
        MessageObject msg = new MessageObject();
        int id = Integer.parseInt(request.getParameter("id"));
        boolean flag = conditionService.deleteCondition(id);
        if(flag)
            msg.setSuccess("成功");
        else
            msg.setError();
        return msg;
    }
}
