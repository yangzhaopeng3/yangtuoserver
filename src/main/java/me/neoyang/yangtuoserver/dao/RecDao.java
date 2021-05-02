package me.neoyang.yangtuoserver.dao;

import me.neoyang.yangtuoserver.bean.Movie;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @name: RecDao
 * @desc:
 * @author: Zhaopeng Yang
 * @create: 2021-04-26 14:28
 **/
@Repository
public interface RecDao {
    List<Movie> recMovie2Movie(Integer movieId);

    List<Movie> recMovie2User(Integer userId);
}
