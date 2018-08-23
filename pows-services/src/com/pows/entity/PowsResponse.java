package com.pows.entity;

import com.google.gson.Gson;

import javax.json.JsonObject;

public class PowsResponse {
    private String status;
    private JsonObject data;
    private String message;
    private Integer code;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public JsonObject getData() {
        return data;
    }

    public void setData(JsonObject data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "PowsResponse{" +
                "status='" + status + '\'' +
                ", data=" + data +
                ", message='" + message + '\'' +
                ", code=" + code +
                '}';
    }

    public String toJsonObject() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
