package com.xx.order.model;

public class MessageObject {
    private Object data;
    private Integer code;

    public Object getData() {
        return data;
    }
    public void setSuccess(Object data){
        this.data = data;
        this.code = 1;
    }
    public void setError(){
        this.data = "失败";
        this.code = 0;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public MessageObject(Object data, Integer code) {
        this.data = data;
        this.code = code;
    }

    public MessageObject() {
    }
}
