package com.fh.ecommerce.mapper;


import com.fh.ecommerce.model.Classify;
import com.fh.ecommerce.model.Property;
import com.fh.ecommerce.model.vo.PropertyParams;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface PropertyDao {
    @Select("<script>" +
            "select count(*) from t_attribute where isDel=0 " +
            " <if test='name!=null and name!=&quot;&quot;'> and nameCH=#{name} </if> " +
            "</script>")
    Long getDataCount(PropertyParams params);
    @Select("<script>" +
            "select * from t_attribute where isDel=0" +
            "<if test='name!=null and name!=&quot;&quot;'> and nameCH=#{name} </if>" +
            " limit  #{startIndex},#{limit}" +
            "</script>")
    List<Property> getDataList(PropertyParams params);
    @Insert("insert into t_attribute (name,nameCH,typeId,type,isSKU,isDel,createDate,author)" +
            " value(#{name},#{nameCH},#{typeId},#{type},#{isSKU},#{isDel},#{createDate},#{author})")
    void add(Property property);
    @Update("update t_attribute set name=#{name},nameCH=#{nameCH},typeId=#{typeId}," +
            " type=#{type},isSKU=#{isSKU},isDel=#{isDel},author=#{author},updateDate=#{updateDate} where id=#{id}")
    void update(Property property);
    @Update("update t_attribute set isDel=1 where id=#{id}")
    void delete(Integer id);

    @Select("select * from t_class")
    List<Classify> queryType();
}
