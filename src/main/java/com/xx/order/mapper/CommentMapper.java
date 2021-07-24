package com.xx.order.mapper;

import com.xx.order.model.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentMapper {
    @Select("select * from comment")
    List<Comment>allComment();
    @Delete("delete from comment where id=#{id}")
    int deleteComment(Integer id);
    @Insert("insert into comment(evaluation,date,grade,username,menuName,picture,orderNumber) values(#{evaluation},#{date},#{grade},#{username},#{menuName},#{picture},#{orderNumber})")
    int addComment(Comment comment);
    @Update("Update orders SET isCash=#{isCash} where number=#{number}")
    int updateOrder(Integer isCash, String number);
}
