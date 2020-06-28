package me.neoyang.yangtuoserver.service.impl;

import me.neoyang.yangtuoserver.dao.MovieDao;
import me.neoyang.yangtuoserver.bean.Movie;
import me.neoyang.yangtuoserver.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @name: MovieServiceImpl
 * @desc:
 * @author: Zhaopeng Yang
 * @create: 2020-06-22 17:50
 **/

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieDao movieDao;

    @Override
    public Movie getMovieById(Integer movieId) {
        return movieDao.getMovieById(movieId);
    }

    @Override
    public List<Movie> getMovies() {
        return movieDao.getMovieList();
    }
}
