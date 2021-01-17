package com.fh.ecommerce.service;

import com.fh.ecommerce.model.Classify;
import com.fh.ecommerce.uitl.CommonsReturn;

import java.util.List;

/**
 * @author huangp
 * @create 2021-01-12 16:56
 */
public interface ClassifyService {


    List<Classify> queryDeptbypid();

    Integer add(Classify classify);

    void update(Classify classify);

    CommonsReturn queryZtree();

    CommonsReturn queryZtrees();
}
