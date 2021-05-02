package me.neoyang.yangtuoserver.controller;

import me.neoyang.yangtuoserver.bean.CheckToken;
import me.neoyang.yangtuoserver.bean.RespBean;
import me.neoyang.yangtuoserver.exception.MyException;
import me.neoyang.yangtuoserver.service.RecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @name: RecController
 * @desc: 推荐相关类
 * @author: Zhaopeng Yang
 * @create: 2021-04-26 12:06
 **/
@RestController
public class RecController {

    @Autowired
    private RecService recService;

    @GetMapping("/movie/{movieId}/suggest")
    public RespBean recMovie2Movie(@PathVariable("movieId") Integer movieId) throws MyException {
        return recService.recMovie2Movie(movieId);
    }

    @CheckToken
    @GetMapping("/people/{userId}/suggest")
    public RespBean recMovie2User(@PathVariable("userId") Integer userId) throws MyException {
        return recService.recMovie2User(userId);
    }
}
