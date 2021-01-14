package com.fh.ecommerce.controller;


import com.fh.ecommerce.model.Pinpai;
import com.fh.ecommerce.service.Pinpaiservice;
import com.fh.ecommerce.uitl.BookParamsVO;
import com.fh.ecommerce.uitl.CommonsReturn;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huangp
 * @create 2021-01-13 18:59
 */
@RequestMapping("/api/pinpai")
@RestController
@CrossOrigin
public class PinpaiController {
    @Resource
    private Pinpaiservice pinpaiservice;
/*
请求方式：post
* 路径：http://localhost:8080/api/pinpai/gettable?currPage=1&size=2
*currPage  当前页必传
* size 每页条数必传
* 返回数据类型 {
    "code": 200,
    "msg": "操作成功",
    "data": {
        "count": 1,
        "list": [
            {
                "id": 3,
                "name": "的士费",
                "bandE": "b",
                "imgpath": null,
                "bandDesc": null,
                "ord": 0,
                "isdel": 0,
                "createDate": null,
                "updateDate": null,
                "author": null
            }
        ]
    }
}
* */
    @PostMapping("gettable")
    public CommonsReturn gettable(BookParamsVO bookParamsVO){
        if(bookParamsVO.getCurrPage()==null){
           return CommonsReturn.error("非法请求");
        }

        if(bookParamsVO.getSize()==null){
            return CommonsReturn.error("非法请求");
        }


        try {
            Map rs =  pinpaiservice.quest(bookParamsVO);
            return CommonsReturn.success(rs);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonsReturn.error("查询失败");
        }


    }
/*请求方式：post
http://localhost:8080/api/pinpai/add
接受参数：{name,bandE,imgpath,bandDesc,ord,isdel,author}
返回类型：{
    "code": 500,
    "msg": "操作失败"}
* */
    @PostMapping("add")
    public CommonsReturn add(Pinpai pinpai){
        pinpaiservice.addBook(pinpai);

        return CommonsReturn.success();
    }
    /*
    * 请求方式：post
http://localhost:8080/api/pinpai/querybyid
接受参数：integer
返回类型：{
    "code": 200,
    "msg": "操作成功",
    "data": [
        {
            "id": 1,
            "name": "阿萨",
            "bandE": null,
            "imgpath": null,
            "bandDesc": null,
            "ord": null,
            "isdel": null,
            "createDate": null,
            "updateDate": null,
            "author": null
        }
    ]
}*/
    @PostMapping("querybyid")
    public CommonsReturn querybyid(Integer id){
        List<Pinpai>pinpais=pinpaiservice.querybyid(id);

        return CommonsReturn.success(pinpais);
    }
    /*
    * 请求方式：post
http://localhost:8080/api/pinpai/update
接受参数：{name,bandE,imgpath,bandDesc,ord,isdel,author,id}
返回类型：{
    "code": 500,
    "msg": "操作失败"}
    * */
    @PostMapping("update")
    public CommonsReturn update(Pinpai pinpai){
        if(pinpai.getId()==null){
            return CommonsReturn.error("没有id");
        }
        try {
            pinpaiservice.update(pinpai);
            return CommonsReturn.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonsReturn.error();
        }

    }
    /* 请求方式：post
http://localhost:8080/api/pinpai/delect
接受参数：integer
返回类型：{
    "code": 500,
    "msg": "操作失败"}
    *
    * */
    @PostMapping("delect")
    public CommonsReturn delect(Integer Id){
        try {
            pinpaiservice.delect(Id);
            return CommonsReturn.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonsReturn.error();
        }

    }
}
