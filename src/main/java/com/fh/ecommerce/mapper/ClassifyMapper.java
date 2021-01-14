package com.fh.ecommerce.mapper;

import com.fh.ecommerce.model.Classify;
import com.fh.ecommerce.uitl.CommonsReturn;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author huangp
 * @create 2021-01-12 16:57
 */
public interface ClassifyMapper {



    List<Classify> queryDeptbypid(Integer pid);


    void add(Classify classify);

    void update(Classify classify);

    List<Map<String, Object>> queryZtree();


    List<Map<String, Object>> queryZtrees();
}
