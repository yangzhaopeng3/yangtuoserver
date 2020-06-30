package me.neoyang.yangtuoserver.service;

import me.neoyang.yangtuoserver.bean.RespBean;
import me.neoyang.yangtuoserver.exception.MyException;

/**
 * @name: MovieService
 * @desc:
 * @author: Zhaopeng Yang
 * @create: 2020-06-22 17:49
 **/

public interface MovieService {
    /**
     * @name: getMovies
     * @desc: 获取电影列表
     * @param: []
     * @return: java.util.List<me.neoyang.yangtuoserver.domain.Movie>
     * @author: Zhaopeng Yang
     * @date: 2020/6/22
     */
    RespBean getMovies(Integer pageNum, Integer pageSize);

    RespBean getMovieById(Integer movieId) throws MyException;
}

