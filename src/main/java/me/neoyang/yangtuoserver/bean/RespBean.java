package me.neoyang.yangtuoserver.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(value = {"handler"})
public class RespBean implements Serializable {

    private Integer code;   //返回码 非0即失败
    private String msg; //消息提示
    private Object data; //返回的数据

    public RespBean() {
    }

    public RespBean(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


}