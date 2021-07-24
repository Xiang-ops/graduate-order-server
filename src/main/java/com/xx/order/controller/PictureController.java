package com.xx.order.controller;

import com.alibaba.fastjson.JSONObject;
import com.xx.order.model.Picture;
import com.xx.order.service.PictureService;
import com.xx.order.utils.FileUploadUtil;
import com.xx.order.utils.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class PictureController {
    @Autowired
    private PictureService pictureService;

//    @PostMapping("")
    @PostMapping("/menu/picture/update")
    public Object updateMenuPic(@RequestParam("file") MultipartFile picFile){
        JSONObject jsonObject = new JSONObject();
        if(picFile.isEmpty()){
            jsonObject.put("code",0);
            jsonObject.put("msg","上传失败");
            return jsonObject;
        }
        String fileName = System.currentTimeMillis()+picFile.getOriginalFilename().substring(picFile.getOriginalFilename().length()-4);
        String filePath = System.getProperty("user.dir")+System.getProperty("file.separator")+"menuPic";
//user.dir指用户的当前工作目录 System.getProperty("...")获取系统属性 file.separator-----文件分隔符
        File file1 = new File(filePath);
        if(!file1.exists()){
            file1.mkdir();
        }

        File dest = new File(filePath+System.getProperty("file.separator")+fileName);
        String storePicPath = "/menuPic/"+fileName;
        String number = UuidUtil.getUUID();
        Picture pic = new Picture();
        pic.setPicUrl(storePicPath);
        pic.setName(fileName);
        pic.setUuid(number);
        System.out.print("执行了此函数");
        try {
            picFile.transferTo(dest);
            System.out.print("test");
            boolean flag = pictureService.addPicture(pic);
            System.out.print(flag);
            if(flag){
                jsonObject.put("code",1);
                jsonObject.put("msg","上传成功");
                jsonObject.put("url",storePicPath);
            }else{
                jsonObject.put("code",0);
                jsonObject.put("msg","上传失败");
            }

        } catch (IOException e) {
            e.printStackTrace();
            jsonObject.put("code",0);
            jsonObject.put("msg","上传失败");
            return jsonObject;
        }finally {
            return jsonObject;
        }

    }

    @PostMapping("update/pictures")
    public Object updatePics(@RequestParam("file") MultipartFile[] picFiles){
        JSONObject jsonObject = new JSONObject();
        System.out.print("多文件上传");
        String uuid = UuidUtil.getUUID();
        Picture pic = new Picture();
        for(int i=0;i<picFiles.length;i++){
            MultipartFile picFile = picFiles[i];
            String fileName = FileUploadUtil.upLoadFile(picFile);
            String storePicPath = "/menuPic/"+fileName;
            if(fileName!=""){
                pic.setPicUrl(storePicPath);
                pic.setName(fileName);
                pic.setUuid(uuid);
                boolean flag = pictureService.addPicture(pic);
                System.out.print(flag);
                if(flag){
                    jsonObject.put("code",1);
                    jsonObject.put("msg","上传成功");
                    jsonObject.put("url",storePicPath);
                    return  jsonObject;
                }
            }
        }
        jsonObject.put("code",0);
        jsonObject.put("msg","上传失败");
        return  jsonObject;

    }

}
