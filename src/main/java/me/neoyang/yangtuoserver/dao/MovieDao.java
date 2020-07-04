package me.neoyang.yangtuoserver.dao;

import me.neoyang.yangtuoserver.bean.Movie;
import me.neoyang.yangtuoserver.exception.MyException;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
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

    List<Movie> getMovieListOrderByRate();

    /**
     * @name: getMovieById
     * @desc: 通过MovieId获取电影详情信息
     * @param: [movieId]
     * @return: me.neoyang.yangtuoserver.bean.Movie
     * @author: Zhaopeng Yang
     * @date: 2020/6/27
     */

    List<Movie> getMoviesRecommend(Integer movieId);

    Integer rec(Integer movieId, Integer userId);

    List<Movie> findRecommends(List list);

    List<Movie> search(String content);


    Movie getMovieById(Integer movieId) throws MyException;


    List<Movie> getWishList(Integer userId);

    List<Movie> getWatchedList(Integer userId);

    List<Movie> selectByTag(HashMap tag);
}
