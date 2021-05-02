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
    List<Movie> getMovieList();

    List<Movie> getMovieListOrderByRate();

    List<Movie> search(String content);

    Movie getMovieById(Integer movieId) throws MyException;

    List<Movie> getWishList(Integer userId);

    List<Movie> getWatchedList(Integer userId);

    List<Movie> selectByTag(HashMap tag);
}
