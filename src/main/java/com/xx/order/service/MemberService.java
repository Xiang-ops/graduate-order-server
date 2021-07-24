package com.xx.order.service;

import com.xx.order.mapper.MemberMapper;
import com.xx.order.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;
import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberMapper memberMapper;
    /**
     * 查找所有会员体系
     */
    public List<Member> selectMemberList(){
        return memberMapper.selectMemberList();
    }
    /**
     * 查找会员等级名
     */
    public String selectName(int id){
        return memberMapper.selectName(id);
    }
    /**
     * 查找对应会员所打折扣
     */
    public int selectDiscount(int id){
        return memberMapper.selectDiscount(id);
    }
}
