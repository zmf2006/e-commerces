package com.fh.ecommerce.service;

import com.fh.ecommerce.model.Pinpai;
import com.fh.ecommerce.uitl.BookParamsVO;

import java.util.List;
import java.util.Map;

/**
 * @author huangp
 * @create 2021-01-13 18:56
 */
public interface Pinpaiservice {
   Map quest(BookParamsVO bookParamsVO);

    void addBook(Pinpai pinpai);

    List<Pinpai> querybyid(Integer id);

    void update(Pinpai pinpai);

    void delect(Integer id);
}
