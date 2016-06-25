package com.example.tyz1201.yourrecipes.model;

import java.io.Serializable;

/**
 * Created by tyz1201 on 2016/5/12.
 */
public class DishKindsModel implements Serializable {
    private String id;
    private String name;
    private String parentId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}
