package com.fh.ecommerce.service.impl;

import com.fh.ecommerce.mapper.AttributeMapper;
import com.fh.ecommerce.model.Attribute;
import com.fh.ecommerce.model.Pinpai;
import com.fh.ecommerce.service.AttributeService;
import com.fh.ecommerce.uitl.BookParamsVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huangp
 * @create 2021-01-14 20:44
 */
@Service
public class AttributeServiceImpl implements AttributeService {
    @Resource
    private AttributeMapper attributeMapper;

    @Override
    public Map quest(BookParamsVO vo) {
        Map rs=new HashMap();
        //查询总条数
        Integer integer = attributeMapper.queryCount(vo);
        rs.put("count",integer);
        //查询分页数据
        List<Attribute> Pinpais = attributeMapper.queryDataByParams(vo);
        rs.put("list",Pinpais);
        return rs;
    }

    @Override
    public void add(Attribute attribute) {
if(attribute.getIsDel()==null){
    attribute.setIsDel(0);
        }
        attributeMapper.addBook(attribute);
    }

    @Override
    public void update(Attribute attribute) {
        attributeMapper.update(attribute);
    }
}
