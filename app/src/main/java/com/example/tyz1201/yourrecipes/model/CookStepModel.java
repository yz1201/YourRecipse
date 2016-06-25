package com.example.tyz1201.yourrecipes.model;

import java.io.Serializable;

/**
 * Created by tyz1201 on 2016/5/12.
 */
public class CookStepModel implements Serializable {
    private String img;
    private String step;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }
}
