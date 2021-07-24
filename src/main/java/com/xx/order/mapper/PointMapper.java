package com.xx.order.mapper;

import com.xx.order.model.Point;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PointMapper {
    @Select("select * from point where userId=#{userId}")
    List<Point> findAllByUser(int userId);
    @Insert("insert into point(userId,time,addPoint,month,stepFlag) values(#{userId},#{time},#{addPoint},#{month},#{stepFlag})")
    int insertPoint(Point point);
    @Select("select SUM(addPoint) from point where userId=#{userId}")
    int getUserPoint(int userId);
}
