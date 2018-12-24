package org.software.ysu.pojo;

import java.util.List;

public class Assort {
    private Integer id;

    private String assortName;

    private Integer assortParentid;

    private List<Assort> assortList;

    private List<Material> materialList;

    public List<Material> getMaterialList() {
        return materialList;
    }

    public void setMaterialList(List<Material> materialList) {
        this.materialList = materialList;
    }

    public List<Assort> getAssortList() {
        return assortList;
    }

    public void setAssortList(List<Assort> assortList) {
        this.assortList = assortList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAssortName() {
        return assortName;
    }

    public void setAssortName(String assortName) {
        this.assortName = assortName == null ? null : assortName.trim();
    }

    public Integer getAssortParentid() {
        return assortParentid;
    }

    public void setAssortParentid(Integer assortParentid) {
        this.assortParentid = assortParentid;
    }
}