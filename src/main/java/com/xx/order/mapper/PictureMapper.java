package com.xx.order.mapper;

import com.xx.order.model.Picture;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PictureMapper {
    @Insert("insert into picture(name,picUrl,uuid) values(#{name},#{picUrl},#{uuid})")
    int addPicture(Picture pic);
}
