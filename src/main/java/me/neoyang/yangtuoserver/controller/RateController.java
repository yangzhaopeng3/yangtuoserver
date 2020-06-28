package me.neoyang.yangtuoserver.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import me.neoyang.yangtuoserver.bean.Movie;
import me.neoyang.yangtuoserver.bean.Rate;
import me.neoyang.yangtuoserver.service.MovieService;
import me.neoyang.yangtuoserver.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @name: MovieController
 * @desc: Movie的控制器
 * @author: Zhaopeng Yang
 * @create: 2020-06-22 22:03
 **/
@RestController
public class RateController {

    @Autowired
    private RateService rateService;


    @GetMapping("/rate/{movieId}")
    public PageInfo getRate(@PathVariable("movieId") Integer movieId,
                            @RequestParam(value = "start", defaultValue = "1") int pageNum,
                            @RequestParam(value = "limit", defaultValue = "10") int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(rateService.getRateByMid(movieId));
        return pageInfo;
    }

}
