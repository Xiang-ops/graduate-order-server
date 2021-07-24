package com.xx.order.controller;

import com.xx.order.model.Comment;
import com.xx.order.service.CommentService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;
    @GetMapping("comment")
    public List<Comment>allComment(){
        return commentService.allComment();
    }
    @GetMapping("comment/delete")
    public Object deleteComment(HttpServletRequest request){
        String id = request.getParameter("id");
        JSONObject jsonObject = new JSONObject();
        boolean flag = commentService.deleteComment(Integer.parseInt(id));
        if(flag){
            jsonObject.put("code",1);
            jsonObject.put("msg","删除成功");
            return jsonObject;
        }
        jsonObject.put("code",0);
        jsonObject.put("msg","删除失败");
        return jsonObject;
    }
//    @PostMapping("comment/pic")
//    public Object updateCommentPic(@RequestParam("file") MultipartFile picFile){
//
//    }
    @PostMapping("comment/add")
    public Object addComment(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String evaluation = request.getParameter("evaluation");
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String grade = request.getParameter("grade");
        String username = request.getParameter("userName");
        String menuName = request.getParameter("menuName");
        String picture = request.getParameter("picture");
        String orderNumber = request.getParameter("orderNumber");
        Comment comment = new Comment();
        comment.setDate(date);
        comment.setOrderNumber(orderNumber);
        comment.setEvaluation(evaluation);
        comment.setPicture(picture);
        comment.setGrade(grade);
        comment.setUsername(username);
        comment.setMenuName(menuName);
        boolean changeFlag = commentService.updateOrder(2,orderNumber);
        if(changeFlag){
            boolean flag = commentService.addComment(comment);
            if(flag){

                jsonObject.put("code",1);
                jsonObject.put("msg","添加成功");
                return jsonObject;
            }
        }
        jsonObject.put("code",0);
        jsonObject.put("msg","添加失败");

        return jsonObject;
    }
}
