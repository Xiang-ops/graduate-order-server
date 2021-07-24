package com.xx.order.mapper;

import com.xx.order.model.Conditions;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ConditionMapper {
    @Select("select * from conditions where menuId=#{menuId}")
    List<Conditions>getGoodsCondition(Integer menuId);
    @Insert("insert into conditions(flagId,menuId,content) values(#{flagId},#{menuId},#{conditionValue}) ")
    int addCondition(int flagId,int menuId,String conditionValue);
    @Delete("Delete from conditions where id=#{id}")
    int deleteCondition(Integer id);
}
