package me.neoyang.yangtuoserver.exception;

/**
 * @name: MyException
 * @desc: 自定义异常类
 * @author: Zhaopeng Yang
 * @create: 2020-06-29 18:21
 **/
public class MyException extends RuntimeException {
    private final String msg;
    private Integer code = -1;

    public MyException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public MyException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
