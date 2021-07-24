package com.xx.order.service;

import com.xx.order.mapper.PictureMapper;
import com.xx.order.model.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PictureService {
    @Autowired
    private PictureMapper pictureMapper;
    public boolean addPicture(Picture picture){
        System.out.print("lalalatest");
        return pictureMapper.addPicture(picture)>0;
    }
}
