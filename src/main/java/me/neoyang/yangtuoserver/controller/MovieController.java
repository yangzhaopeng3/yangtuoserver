package me.neoyang.yangtuoserver.controller;

import me.neoyang.yangtuoserver.bean.RespBean;
import me.neoyang.yangtuoserver.exception.MyException;
import me.neoyang.yangtuoserver.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}
