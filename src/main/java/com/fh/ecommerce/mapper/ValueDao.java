package com.fh.ecommerce.mapper;

import com.fh.ecommerce.model.Value;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ValueDao {
    @Select("select * from t_shuxingzhi where propertyId=#{propertyId} and isDel=0")
    List<Value> getData(Integer propertyId);
    @Insert("insert into t_shuxingzhi (value,valueCH,propertyId) value(#{value},#{valueCH},#{propertyId})")
    void add(Value value);
    @Update("update t_shuxingzhi set value=#{value},valueCH=#{valueCH},propertyId=#{propertyId} where id=#{id}")
    void update(Value value);
    @Update("update t_shuxingzhi set isDel=1 where id=#{id}")
    void delete(Integer id);
}
