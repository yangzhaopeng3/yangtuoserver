package me.neoyang.yangtuoserver.service;

import me.neoyang.yangtuoserver.bean.RespBean;

/**
 * @name: RecService
 * @desc:
 * @author: Zhaopeng Yang
 * @create: 2021-04-26 14:22
 **/
public interface RecService {


    RespBean recMovie2User(Integer userId);

    RespBean recMovie2Movie(Integer movieId);
}
