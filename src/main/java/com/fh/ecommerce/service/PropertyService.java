package com.fh.ecommerce.service;



import com.fh.ecommerce.model.Classify;
import com.fh.ecommerce.model.Property;
import com.fh.ecommerce.model.vo.PageResult;
import com.fh.ecommerce.model.vo.PropertyParams;

import java.util.List;

public interface PropertyService {
    PageResult getData(PropertyParams params);

    void add(Property property);

    void update(Property property);

    void delete(Integer id);

    List<Classify> queryType();
}
