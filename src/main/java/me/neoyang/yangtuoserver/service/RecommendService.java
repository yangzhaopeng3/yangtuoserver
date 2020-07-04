package me.neoyang.yangtuoserver.service;

import me.neoyang.yangtuoserver.bean.RespBean;

/**
 * @name: RecommendService
 * @desc:
 * @author: Zhaopeng Yang
 * @create: 2020-07-03 22:33
 **/

public interface RecommendService {
    RespBean recommendByUserBased(Integer userId, int size);

    RespBean recommendByItemBased(Integer userId, int size);
}