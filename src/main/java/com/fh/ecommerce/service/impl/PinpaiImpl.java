package com.fh.ecommerce.service.impl;

import com.fh.ecommerce.mapper.PinpaiMapper;

import com.fh.ecommerce.model.Pinpai;
import com.fh.ecommerce.service.Pinpaiservice;
import com.fh.ecommerce.uitl.BookParamsVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.awt.print.Book;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huangp
 * @create 2021-01-13 18:56
 */
@Service
public class PinpaiImpl implements Pinpaiservice {
    @Resource
    private PinpaiMapper pinpaiMapper;

    @Override
    public Map quest(BookParamsVO vo) {

        Map rs=new HashMap();
        //查询总条数
        Integer integer = pinpaiMapper.queryCount(vo);
        rs.put("count",integer);
        //查询分页数据
        List<Book> books = pinpaiMapper.queryDataByParams(vo);
        rs.put("list",books);
        return rs;
    }

    @Override
    public void addBook(Pinpai pinpai) {
        if (pinpai.getId()==null){
            pinpai.setId(0);
        }
        pinpaiMapper.addBook(pinpai);
    }

    @Override
    public List<Pinpai> querybyid(Integer id) {
        return pinpaiMapper.querybyid(id);
    }

    @Override
    public void update(Pinpai pinpai) {
        pinpaiMapper.update(pinpai);
    }

    @Override
    public void delect(Integer id) {
        pinpaiMapper.delect(id);
    }
}
