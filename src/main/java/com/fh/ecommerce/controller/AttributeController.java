package com.fh.ecommerce.controller;

import com.fh.ecommerce.service.AttributeService;
import com.fh.ecommerce.uitl.BookParamsVO;
import com.fh.ecommerce.uitl.CommonsReturn;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author huangp
 * @create 2021-01-14 20:45
 */
@RestController
@RequestMapping("api/attr")
@CrossOrigin
public class AttributeController {
    @Resource
    private AttributeService attributeService;
    @PostMapping("gettable")
    public CommonsReturn gettable(BookParamsVO bookParamsVO){
        if(bookParamsVO.getCurrPage()==null){
            return CommonsReturn.error("非法请求");
        }

        if(bookParamsVO.getSize()==null){
            return CommonsReturn.error("非法请求");
        }


        try {
            Map rs =  attributeService.quest(bookParamsVO);
            return CommonsReturn.success(rs);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonsReturn.error("查询失败");
        }

    }
}