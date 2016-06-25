package com.example.tyz1201.yourrecipes.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tyz1201 on 2016/5/12.
 */
public class CookbookTagsModel {
    private String resultcode;
    private String reason;
    private ArrayList<CbTagsModel> result;

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ArrayList<CbTagsModel> getResult() {
        return result;
    }

    public void setResult(ArrayList<CbTagsModel> result) {
        this.result = result;
    }
}
