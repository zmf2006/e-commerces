package com.fh.ecommerce.mapper;

import com.fh.ecommerce.model.Pinpai;
import com.fh.ecommerce.uitl.BookParamsVO;

import java.awt.print.Book;
import java.util.List;

/**
 * @author huangp
 * @create 2021-01-13 18:58
 */
public interface PinpaiMapper {


    Integer queryCount(BookParamsVO vo);

    List<Pinpai> queryDataByParams(BookParamsVO vo);

    void addBook(Pinpai pinpai);

    List<Pinpai> querybyid(Integer id);

    void update(Pinpai pinpai);

    void delect(Integer id);
}
