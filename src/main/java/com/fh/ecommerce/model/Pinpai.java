package com.fh.ecommerce.model;

import javax.xml.crypto.Data;

/**
 * @author huangp
 * @create 2021-01-13 18:44
 */
public class Pinpai {

    private  Integer id;//主键
    private String name;//名称
    private String bandE;// 首字母
    private String imgpath;//图片log
    private String bandDesc;//品牌介绍
    private Integer ord ;//排序字段
    private Integer isdel  ;//逻辑删除
    private Data createDate ;//创建时间
    private Data updateDate ;//时修改时间
    private String author;//操作人

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

    public String getBandE() {
        return bandE;
    }

    public void setBandE(String bandE) {
        this.bandE = bandE;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    public String getBandDesc() {
        return bandDesc;
    }

    public void setBandDesc(String bandDesc) {
        this.bandDesc = bandDesc;
    }

    public Integer getOrd() {
        return ord;
    }

    public void setOrd(Integer ord) {
        this.ord = ord;
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
