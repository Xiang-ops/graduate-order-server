package com.xx.order.utils;

import com.alibaba.fastjson.JSONObject;
import com.xx.order.model.Picture;
import com.xx.order.service.PictureService;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileUploadUtil {
//    private static PictureService pictureService;
    public static String upLoadFile(MultipartFile picFile){
//        JSONObject jsonObject = new JSONObject();
        String storePicPath = "";
        if(picFile.isEmpty()){
//            jsonObject.put("code",0);
//            jsonObject.put("msg","上传失败");
            return "";
        }
        String fileName = System.currentTimeMillis()+picFile.getOriginalFilename().substring(picFile.getOriginalFilename().length()-4);
        String filePath = System.getProperty("user.dir")+System.getProperty("file.separator")+"menuPic";
//user.dir指用户的当前工作目录 System.getProperty("...")获取系统属性 file.separator-----文件分隔符
        File file1 = new File(filePath);
        if(!file1.exists()){
            file1.mkdir();
        }

        File dest = new File(filePath+System.getProperty("file.separator")+fileName);

//        String number = UuidUtil.getUUID();
//        Picture pic = new Picture();
//        pic.setPicUrl(storePicPath);
//        pic.setName(fileName);
//        pic.setUuid(number);
        System.out.print("执行了此函数");
        try {
            picFile.transferTo(dest);
//            System.out.print("test");
//            boolean flag = pictureService.addPicture(pic);
//            System.out.print(flag);
//            if(flag){
//                jsonObject.put("code",1);
//                jsonObject.put("msg","上传成功");
//                jsonObject.put("url",storePicPath);
//            }else{
//                jsonObject.put("code",0);
//                jsonObject.put("msg","上传失败");
//            }

        } catch (IOException e) {
            return "";
//            e.printStackTrace();
//            jsonObject.put("code",0);
//            jsonObject.put("msg","上传失败");
//            return jsonObject;
        }finally {
            return fileName;
//            return jsonObject;
        }
    }
}
