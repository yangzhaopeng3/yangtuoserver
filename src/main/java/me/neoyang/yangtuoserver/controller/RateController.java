package me.neoyang.yangtuoserver.controller;

import me.neoyang.yangtuoserver.bean.CheckToken;
import me.neoyang.yangtuoserver.bean.Rate;
import me.neoyang.yangtuoserver.bean.RespBean;
import me.neoyang.yangtuoserver.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @CheckToken
    @PostMapping("/rate")
    public RespBean makeRate(Rate rate) throws Exception {
        return rateService.makeRate(rate);
    }

    @CheckToken
    @GetMapping("/rate/{movieId}")
    public RespBean getRate(@PathVariable("movieId") Integer movieId,
                            @RequestParam(value = "start", defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "limit", defaultValue = "10") Integer pageSize)
            throws Exception {
        return rateService.getRateByMid(movieId, pageNum, pageSize);
    }

}
