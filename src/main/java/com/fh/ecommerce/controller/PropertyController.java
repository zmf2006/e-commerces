package com.fh.ecommerce.controller;

import com.fh.ecommerce.model.Classify;
import com.fh.ecommerce.model.Property;
import com.fh.ecommerce.model.vo.PageResult;
import com.fh.ecommerce.model.vo.PropertyParams;
import com.fh.ecommerce.service.PropertyService;
import com.fh.ecommerce.uitl.CommonsReturn;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("PropertyController")
@CrossOrigin
public class PropertyController {
    @Resource
    PropertyService propertyService;

    /*
    接口：分页 查询所有的属性数据
    * 请求：post请求
    * 参数 page 当前页（必传） ,limit 每页显示条数（必传）,name 条件查询
    * 返回值   {"code":0,count="总条数",data:[{*}]}
    *路径：http://192.168.235.1:8080/PropertyController/getDate
    * */
    @PostMapping("getDate")
    public PageResult getDate(PropertyParams params){
        PageResult result=propertyService.getData(params);
        return result;
    }
    @PostMapping("add")
    public CommonsReturn add(Property property){
        propertyService.add(property);
        return CommonsReturn.success(null);
    }
    @PostMapping("update")
    public CommonsReturn update(Property property){
        if(property.getId()==null){
            return CommonsReturn.error(500);
        }else{
            propertyService.update(property);
            return CommonsReturn.success(null);
        }
    }
    @GetMapping("delete")
    public CommonsReturn delete(Integer id){
        if(id==null){
            return CommonsReturn.error(400);
        }
        propertyService.delete(id);
        return CommonsReturn.success(null);
    }

    @RequestMapping("queryType")
    public CommonsReturn queryType(){
        List<Classify> list=propertyService.queryType();
        return  CommonsReturn.success(list);
    }



}
