package me.neoyang.yangtuoserver.dao;

import me.neoyang.yangtuoserver.bean.Movie;
import me.neoyang.yangtuoserver.exception.MyException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @name: MovieDao
 * @desc:
 * @author: Zhaopeng Yang
 * @create: 2020-06-22 21:13
 **/

@Repository
public interface MovieDao {
    /**
     * @name: getMovieList
     * @desc: 获取MovieList
     * @param: []
     * @return: java.util.List<me.neoyang.yangtuoserver.domain.Movie>
     * @author: Zhaopeng Yang
     * @date: 2020/6/22
     */
    List<Movie> getMovieList();

    /**
     * @name: getMovieById
     * @desc: 通过MovieId获取电影详情信息
     * @param: [movieId]
     * @return: me.neoyang.yangtuoserver.bean.Movie
     * @author: Zhaopeng Yang
     * @date: 2020/6/27
     */
    Movie getMovieById(Integer movieId) throws MyException;
}
