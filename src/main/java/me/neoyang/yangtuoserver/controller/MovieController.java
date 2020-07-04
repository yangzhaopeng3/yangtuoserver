package me.neoyang.yangtuoserver.controller;

import me.neoyang.yangtuoserver.bean.CheckToken;
import me.neoyang.yangtuoserver.bean.RespBean;
import me.neoyang.yangtuoserver.exception.MyException;
import me.neoyang.yangtuoserver.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @name: MovieController
 * @desc: Movie的控制器
 * @author: Zhaopeng Yang
 * @create: 2020-06-22 22:03
 **/
@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;


    @CheckToken
    @GetMapping("/people/{userId}/wish")
    public RespBean getWishList(@PathVariable("userId") Integer userId,
                                @RequestParam(value = "start", defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "limit", defaultValue = "10") Integer pageSize) {
        return movieService.getWishList(userId, pageNum, pageSize);
    }


    @GetMapping("/people/{userId}/collect")
    @CheckToken
    public RespBean getWatchedList(@PathVariable("userId") Integer userId,
                                   @RequestParam(value = "start", defaultValue = "1") Integer pageNum,
                                   @RequestParam(value = "limit", defaultValue = "10") Integer pageSize) {
        return movieService.getWatchedList(userId, pageNum, pageSize);
    }


    /**
     * @name: getMovies
     * @desc: 返回所有电影数据
     * @param: []
     * @return: java.util.List<me.neoyang.yangtuoserver.bean.Movie>
     * @author: Zhaopeng Yang
     * @date: 2020/6/28
     */
    @GetMapping("/movies")
    public RespBean getMovies(@RequestParam(value = "start", defaultValue = "1") int pageNum,
                              @RequestParam(value = "limit", defaultValue = "10") int pageSize) throws MyException {
        return movieService.getMovies(pageNum, pageSize);
    }

    /**
     * @name: getMovies
     * @desc: 返回所有电影数据oder by rate desc
     * @param: []
     * @return: java.util.List<me.neoyang.yangtuoserver.bean.Movie>
     * @author: Zhaopeng Yang
     * @date: 2020/6/28
     */
    @GetMapping("/movies/chart")
    public RespBean getMovieChart(@RequestParam(value = "start", defaultValue = "1") int pageNum,
                                  @RequestParam(value = "limit", defaultValue = "12") int pageSize) throws MyException {
        return movieService.getMoviesOrderByRate(pageNum, pageSize);
    }


    @GetMapping("movies/tag")
    public RespBean getMoviesByTag(@RequestParam HashMap map) {
        System.out.println(map);
        return movieService.getMoviebyTag(map);
    }


    @GetMapping("movies/search/{content}")
    public RespBean search(@PathVariable("content") String content,
                           @RequestParam(value = "start", defaultValue = "1") int pageNum,
                           @RequestParam(value = "limit", defaultValue = "12") int pageSize) {
        return movieService.search(content, pageNum, pageSize);
    }

    /**
     * @name: getMovie
     * @desc: 返回特定电影数据
     * @param: [movieId]
     * @return: me.neoyang.yangtuoserver.bean.Movie
     * @author: Zhaopeng Yang
     * @date: 2020/6/28
     */
    @GetMapping("/movie/{movieId}")
    public RespBean getMovie(@PathVariable("movieId") Integer movieId) throws MyException {
        return movieService.getMovieById(movieId);
    }

    @GetMapping("/movie/rec/{movieId}")
    public RespBean getMovieRecommend(@PathVariable("movieId") Integer movieId) {
        return movieService.getMovieRecommend(movieId);
    }


}
