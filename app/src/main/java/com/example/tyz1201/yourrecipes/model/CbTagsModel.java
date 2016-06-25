package com.example.tyz1201.yourrecipes.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tyz1201 on 2016/5/12.
 */
public class CbTagsModel implements Serializable{
    private String parentId;
    private String name;
    private List<DishKindsModel> list;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DishKindsModel> getList() {
        return list;
    }

    public void setList(List<DishKindsModel> list) {
        this.list = list;
    }
}
