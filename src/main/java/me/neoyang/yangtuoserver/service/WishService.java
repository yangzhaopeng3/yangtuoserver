package me.neoyang.yangtuoserver.service;

import me.neoyang.yangtuoserver.bean.RespBean;
import me.neoyang.yangtuoserver.bean.Wish;

/**
 * @name: WishService
 * @desc:
 * @author: Zhaopeng Yang
 * @create: 2020-07-02 13:28
 **/
public interface WishService {
    RespBean getUsersWishList(Integer userId);

    RespBean getUsersWishOfAMovie(Wish wish);

    RespBean cancelWish(Integer wid);

    RespBean makeWish(Wish wish);
}
