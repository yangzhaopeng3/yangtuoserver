package me.neoyang.yangtuoserver.service;

import me.neoyang.yangtuoserver.bean.RespBean;
import me.neoyang.yangtuoserver.exception.MyException;

import java.util.HashMap;

/**
 * @name: MovieService
 * @desc:
 * @author: Zhaopeng Yang
 * @create: 2020-06-22 17:49
 **/

public interface MovieService {
    RespBean getMovies(Integer pageNum, Integer pageSize);

    RespBean getMovieById(Integer movieId) throws MyException;

    RespBean getWatchedList(Integer userId, Integer pageNum, Integer pageSize);

    RespBean getWishList(Integer userId, Integer pageNum, Integer pageSize);

    RespBean getMoviesOrderByRate(int pageNum, int pageSize);

    RespBean getMoviebyTag(HashMap map);

    RespBean search(String content, Integer pageNum, Integer pageSize);
}

