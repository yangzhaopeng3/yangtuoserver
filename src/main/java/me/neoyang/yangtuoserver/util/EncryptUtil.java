package me.neoyang.yangtuoserver.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @name: EncryptUtil
 * @desc: 加密工具类
 * @author: Zhaopeng Yang
 * @create: 2020-06-30 19:02
 **/
public abstract class EncryptUtil {
    public static String encodeData(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(str.getBytes());
            byte[] byteData = md.digest();

            //将字节转换为十六进制格式方法一
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}