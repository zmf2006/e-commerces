package com.fh.ecommerce.service.impl;

import com.fh.ecommerce.mapper.ClassifyMapper;
import com.fh.ecommerce.model.Classify;
import com.fh.ecommerce.service.ClassifyService;
import com.fh.ecommerce.uitl.CommonsReturn;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author huangp
 * @create 2021-01-12 16:56
 */
@Service
public class ClassifyServiceImpl implements ClassifyService {
    @Resource
    private ClassifyMapper classifyMapper;


    @Override
    public List<Classify> queryDeptbypid(Integer pid) {
        return classifyMapper. queryDeptbypid( pid);
    }

    @Override

    public Integer add(Classify classify) {
        if(classify.getIsDel()==null){
            classify.setIsDel(0);
        }

        classifyMapper.add(classify);
       Integer a= classify.getId();
        return a ;
    }

    @Override
    public void update(Classify classify) {
        if(classify.getIsDel()==null){

            classify.setIsDel(0);
        }
        classifyMapper.update(classify);
    }

    @Override
    public CommonsReturn queryZtree() {
        List<Map<String,Object>> ztreeList= null;
        try {
            ztreeList = classifyMapper.queryZtree();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonsReturn.error("查询失败");
        }
        /*parentList 根节点*/
        List<Map<String, Object>> parentList = new ArrayList<>();
        for (Map ztree : ztreeList) {
            if(ztree.get("pid").equals(0)){
                parentList.add(ztree);
            }
        }
        getChildrenList(ztreeList,parentList);
        return CommonsReturn.success(parentList);
    }

    @Override
    public CommonsReturn queryZtrees() {
        List<Map<String,Object>> ztreeList= null;
        try {
            ztreeList = classifyMapper.queryZtrees();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonsReturn.error("查询失败");
        }
        /*parentList 根节点*/
        List<Map<String, Object>> parentList = new ArrayList<>();
        for (Map ztree : ztreeList) {
            if(ztree.get("pid").equals(0)){
                parentList.add(ztree);
            }
        }
        getChildrenList(ztreeList,parentList);
        return CommonsReturn.success(parentList);

    }

    private void getChildrenList(List<Map<String,Object>> ztreeList,List<Map<String, Object>> parentList){
        if(parentList!=null && parentList.size()>0){
            for (Map<String, Object> parentMap : parentList) {
                List<Map<String,Object>> childrenList = new ArrayList<>();
                /*子节点*/
                for (Map<String, Object> ztreeMap : ztreeList) {
                    if(parentMap.get("id").equals(ztreeMap.get("pid"))){
                        childrenList.add(ztreeMap);
                    }
                }
                if(childrenList.size()>0){
                    parentMap.put("children",childrenList);
                    getChildrenList(ztreeList,childrenList);
                }
            }
        }
    }
}
