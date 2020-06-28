package me.neoyang.yangtuoserver;

import me.neoyang.yangtuoserver.dao.MovieDao;
import me.neoyang.yangtuoserver.bean.Movie;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @name: MovieTest
 * @desc:
 * @author: Zhaopeng Yang
 * @create: 2020-06-22 21:20
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MovieTest {

    @Autowired
    private MovieDao movieDao;

    @Test
    public void testMovieDao1() {
        List<Movie> movies = movieDao.getMovieList();
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }
}
