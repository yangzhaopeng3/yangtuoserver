package me.neoyang.yangtuoserver.service;

import me.neoyang.yangtuoserver.bean.Movie;

import java.util.List;

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
    public List<Movie> getMovies();

    public Movie getMovieById(Integer movieId);
}

