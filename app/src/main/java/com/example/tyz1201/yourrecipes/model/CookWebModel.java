package com.example.tyz1201.yourrecipes.model;

/**
 * Created by tyz1201 on 2016/5/12.
 */
public class CookWebModel {
    private String resultcode;
    private String reason;
    private CookingResultModel result;

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

    public CookingResultModel getResult() {
        return result;
    }

    public void setResult(CookingResultModel result) {
        this.result = result;
    }
}
