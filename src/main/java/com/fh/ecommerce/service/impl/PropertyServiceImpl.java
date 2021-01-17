package com.fh.ecommerce.service.impl;


import com.fh.ecommerce.mapper.PropertyDao;
import com.fh.ecommerce.model.Classify;
import com.fh.ecommerce.model.Property;
import com.fh.ecommerce.model.vo.PageResult;
import com.fh.ecommerce.model.vo.PropertyParams;
import com.fh.ecommerce.service.PropertyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Resource
    PropertyDao propertyDao;
    @Override
    public PageResult getData(PropertyParams params) {
        Long count=propertyDao.getDataCount(params);

        params.setStartIndex((params.getPage()-1)*params.getLimit());
        List<Property> list=propertyDao.getDataList(params);
        PageResult result=new PageResult();
        result.setCount(count);
        result.setData(list);
        result.setCode(0);
        result.setMsg("");
        return result;
    }

    @Override
    public void add(Property property) {
        property.setIsDel(0);
        property.setCreateDate(new Date());
        propertyDao.add(property);
    }

    @Override
    public void update(Property property) {
        if(property.getIsDel()==null){
            property.setIsDel(0);
        }
        property.setUpdateDate(new Date());
        propertyDao.update(property);
    }

    @Override
    public void delete(Integer id) {
        propertyDao.delete(id);
    }

    @Override
    public List<Classify> queryType() {
        List<Classify> list=propertyDao.queryType();
        return list;
    }
}
