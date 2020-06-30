package me.neoyang.yangtuoserver.util;

import me.neoyang.yangtuoserver.bean.RespBean;

/**
 * @name: ResultUtil
 * @desc:
 * @author: Zhaopeng Yang
 * @create: 2020-06-29 18:08
 **/
public class ResultUtil {
    public static RespBean success(Object data) {
        return new RespBean(0, "操作成功", data);
    }

    public static RespBean success(String msg, Object data) {
        return new RespBean(0, msg, data);
    }

    public static RespBean error(Integer code, String msg) {
        return new RespBean(code, msg, null);
    }

}
