package com.xx.order.service;

import com.xx.order.mapper.CommentMapper;
import com.xx.order.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
@Autowired
    private CommentMapper commentMapper;
/**
 * 获取所有的评论
 */
public List<Comment>allComment(){
    return commentMapper.allComment();
}
/**
 * 删除某个评论
 */
public Boolean deleteComment(Integer id){
    return commentMapper.deleteComment(id)>0;
}
/**
 * 添加某个评论
 */
public Boolean addComment(Comment comment){
    return commentMapper.addComment(comment)>0;
}
/**
 * 评论完后改变订单状态
 */
public Boolean updateOrder(Integer isCash,String orderNumber){
    return commentMapper.updateOrder(isCash,orderNumber)>0;
}
}
