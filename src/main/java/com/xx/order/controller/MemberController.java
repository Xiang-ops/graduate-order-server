package com.xx.order.controller;

import com.xx.order.model.Member;
import com.xx.order.service.MemberService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin
@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;
    @GetMapping("get/level/list")
    public Object findLevelList(){
        JSONObject jsonObject = new JSONObject();
        List<Member> levelList = memberService.selectMemberList();
        jsonObject.put("levelList",levelList);
        jsonObject.put("code",1);
        return jsonObject;
    }
    @GetMapping("get/user/level")
    public Object getUserLevel(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        int userAmount = Integer.parseInt(request.getParameter("amount"));
        int flag = 0;
        List<Member> levelList = memberService.selectMemberList();
        for(Member x:levelList){
            if(x.getAmount()<userAmount)
                flag = x.getId();
        }
        jsonObject.put("code",1);
        jsonObject.put("flag",flag);
        return jsonObject;
    }
    @GetMapping("get/level/name")
    public Object getLevelName(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        int flagId = Integer.parseInt(request.getParameter("flagId"));
        String levelName = memberService.selectName(flagId);
        jsonObject.put("code",1);
        jsonObject.put("levelName",levelName);
        return jsonObject;
    }
    @GetMapping("get/member/discount")
    public Object getMemberDisount(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        int flagId = Integer.parseInt(request.getParameter("isMember"));
        int shopDiscount = memberService.selectDiscount(flagId);
        jsonObject.put("code",1);
        jsonObject.put("shopDiscount",shopDiscount);
        return jsonObject;
    }
}
