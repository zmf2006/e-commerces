package com.fh.ecommerce.controller;


import com.fh.ecommerce.model.Value;
import com.fh.ecommerce.service.ValueService;
import com.fh.ecommerce.uitl.CommonsReturn;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("ValueController")
public class ValueController {
    @Resource
    ValueService valueService;


    @GetMapping("getData")
    public CommonsReturn getData(Integer id){
        if(id==null){
            return  CommonsReturn.error(400);
        }
        List<Value> list=valueService.getData(id);
        return CommonsReturn.success(list);
    }
    @PostMapping("add")
    public CommonsReturn add(Value value){
        valueService.add(value);
        return CommonsReturn.success(null);
    }
    @PostMapping("update")
    public CommonsReturn update(Value value){
        valueService.update(value);
        return CommonsReturn.success(null);
    }
    @GetMapping("delete")
    public CommonsReturn delete(Integer id){
        valueService.delete(id);
        return CommonsReturn.success(null);
    }
}
