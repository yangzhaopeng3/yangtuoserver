package me.neoyang.yangtuoserver.service;

import me.neoyang.yangtuoserver.bean.RespBean;
import me.neoyang.yangtuoserver.bean.User;

/**
 * @name: UserService
 * @desc:
 * @author: Zhaopeng Yang
 * @create: 2020-06-29 20:32
 **/
public interface UserService {

    RespBean register(User user);

    RespBean login(User user);
}
