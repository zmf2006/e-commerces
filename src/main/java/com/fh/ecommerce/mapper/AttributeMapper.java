package com.fh.ecommerce.mapper;

import com.fh.ecommerce.model.Attribute;
import com.fh.ecommerce.uitl.BookParamsVO;

import java.util.List;

/**
 * @author huangp
 * @create 2021-01-14 20:43
 */
public interface AttributeMapper {
    Integer queryCount(BookParamsVO vo);

    List<Attribute> queryDataByParams(BookParamsVO vo);

    void addBook(Attribute attribute);

    void update(Attribute attribute);

    void delect(Integer id);
}
