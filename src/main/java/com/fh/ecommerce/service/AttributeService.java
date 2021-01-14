package com.fh.ecommerce.service;

import com.fh.ecommerce.model.Attribute;
import com.fh.ecommerce.uitl.BookParamsVO;

import java.util.Map;

/**
 * @author huangp
 * @create 2021-01-14 20:43
 */
public interface AttributeService {
    Map quest(BookParamsVO bookParamsVO);

    void add(Attribute attribute);

    void update(Attribute attribute);
}
