package com.xx.order.mapper;

import com.xx.order.model.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MemberMapper {
    @Select("select * from member")
    List<Member> selectMemberList();
    @Select("select levelName from member where id=#{id}")
    String selectName(int id);
    @Select("select shopDiscount from member where id=#{id}")
    int selectDiscount(int id);
}
