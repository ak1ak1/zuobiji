package com.aqi.zuobiji.Utils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class JsonResult implements Serializable {
    private Integer state;
    private String message;
    private Map data;

    public JsonResult() {
    }

    public JsonResult(Integer state, String message) {
        this.state = state;
        this.message = message;
    }

    public JsonResult(Integer state, String message, Map data) {
        this.state = state;
        this.message = message;
        this.data = data;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "state=" + state +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map getData() {
        return data;
    }

    public void setData(Map data) {
        this.data = data;
    }
}
