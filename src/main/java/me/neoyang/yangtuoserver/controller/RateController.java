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
    public RespBean makeRate(@RequestBody Rate rate) throws Exception {
        return rateService.makeRate(rate);
    }

    @GetMapping("/rate/{movieId}/my/{userId}")
    public RespBean getMyRate(@PathVariable("movieId") Integer movieId,
                              @PathVariable("userId") Integer userId) throws Exception {
        return rateService.getARateOfUser(movieId, userId);
    }


    @CheckToken
    @DeleteMapping("/rate/{cid}")
    public RespBean deleteRate(@PathVariable("cid") Integer cid) {
        return rateService.deleteRate(cid);
    }

    @CheckToken
    @PutMapping("/rate")
    public RespBean updateRate(@RequestBody Rate rate) {
        return rateService.updateRate(rate);
    }


    @GetMapping("/rate/{movieId}")
    public RespBean getRate(@PathVariable("movieId") Integer movieId,
                            @RequestParam(value = "start", defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "limit", defaultValue = "10") Integer pageSize)
            throws Exception {
        return rateService.getRateByMid(movieId, pageNum, pageSize);
    }

}
