package com.fh.ecommerce.controller;

import com.fh.ecommerce.model.Classify;
import com.fh.ecommerce.service.ClassifyService;
import com.fh.ecommerce.uitl.CommonsReturn;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huangp
 * @create 2021-01-12 16:58
 */

@RequestMapping("/api/type")
@RestController
@CrossOrigin
public class ClassifyController {
    @Resource
        private ClassifyService classifyService;

    @GetMapping("getData")
    public CommonsReturn getData(){


        return  classifyService.queryZtree();

    }
    @GetMapping("getDatas")
    public CommonsReturn getDatas(){


        return  classifyService.queryZtrees();

    }
@GetMapping("getDataByPid")
    public Map getDataByPid(Integer Pid){
    Map map = new HashMap();
    try {
        List<Classify> ss =classifyService.queryDeptbypid(Pid);
        map.put("code",200);
        map.put("message","查询成功");
        map.put("data",ss);
    } catch (Exception e) {
        e.printStackTrace();
        map.put("code",500);
        map.put("message","查询失败");

    }

    return map;
}
/*  新增分类*/
    @PostMapping("add")
    public  Map add(Classify classify){
        Map map = new HashMap();
        try {
            Integer a = classifyService.add(classify);
            map.put("code",200);
            map.put("message","新增成功");
            map.put("data",a);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code",500);
            map.put("message","新增失败");
        }
        return map;
    }
@PostMapping("update")
    public  Map update(Classify classify){
    Map map = new HashMap();
        if(classify.getId()==null){
            map.put("code",500);
            map.put("message","id没传");
        return  map;
        }
    try {
        classifyService.update(classify);
        map.put("code",200);
        map.put("message","修改成功");

    } catch (Exception e) {
        e.printStackTrace();
        map.put("code",500);
        map.put("message","修改失败");
    }

    return map;
}
}
