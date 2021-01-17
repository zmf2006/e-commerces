package com.fh.ecommerce.model;

/**
 * @author huangp
 * @create 2021-01-17 19:33
 */
public class PinpaiAndAtrr {
    private Integer id;

    private String name;

    private  String Fenleiname;
    private String nameCH;

    private Integer typeId;

    private Integer  type;

    private Integer isSKU;

    private  Integer isDel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFenleiname() {
        return Fenleiname;
    }

    public void setFenleiname(String fenleiname) {
        Fenleiname = fenleiname;
    }

    public String getNameCH() {
        return nameCH;
    }

    public void setNameCH(String nameCH) {
        this.nameCH = nameCH;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIsSKU() {
        return isSKU;
    }

    public void setIsSKU(Integer isSKU) {
        this.isSKU = isSKU;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
