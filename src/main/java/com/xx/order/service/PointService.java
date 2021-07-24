package com.xx.order.service;

import com.xx.order.mapper.PointMapper;
import com.xx.order.model.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointService {
    @Autowired
    private PointMapper pointMapper;
    /**
     * 查找用户积分
     */
    public List<Point> findAllByUser(int userId){
        return pointMapper.findAllByUser(userId);
    }

    public Boolean addPoint(Point point){
        return pointMapper.insertPoint(point)>0;
    }
    public int getUserPoint(int userId){
        return pointMapper.getUserPoint(userId);
    }
}
