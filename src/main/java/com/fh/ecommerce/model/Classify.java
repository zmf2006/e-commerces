package com.fh.ecommerce.model;

import javax.xml.crypto.Data;

/**
 * @author huangp
 * @create 2021-01-12 16:51
 */
public class Classify {
    private  Integer id;/*主键*/
    private  String name;/*分类名称*/
    private  Integer pid;/*上级ID*/
    private Data createDate;/*新建时间*/
    private  Data updateDate;/*修改时间*/
    private  Integer isDel;/*是否删除*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Data getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Data createDate) {
        this.createDate = createDate;
    }

    public Data getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Data updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
}
