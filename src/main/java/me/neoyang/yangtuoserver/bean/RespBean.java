package me.neoyang.yangtuoserver.bean;

import java.io.Serializable;

/**
 * @name: RespBean
 * @desc: 通用响应对象
 * @author: Zhaopeng Yang
 * @create: 2020-06-22 22:16
 **/
public class RespBean implements Serializable {
    //响应码 0 -success 1 - failure
    private Integer statusCode;
    //响应消息
    private String msg;
    //数据
    private Object data;

    public RespBean(){}

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
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