package me.neoyang.yangtuoserver.controller;

import me.neoyang.yangtuoserver.bean.CheckToken;
import me.neoyang.yangtuoserver.bean.RespBean;
import me.neoyang.yangtuoserver.bean.Wish;
import me.neoyang.yangtuoserver.service.WishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @name: WishController
 * @desc:
 * @author: Zhaopeng Yang
 * @create: 2020-07-02 13:27
 **/

@RestController
public class WishController {


    @Autowired
    private WishService wishService;

    @CheckToken
    @GetMapping("/wish/{userId}/m/{movieId}")
    public RespBean getUsersWishOfAMovie(@PathVariable("userId") Integer userId,
                                         @PathVariable("movieId") Integer movieId) {
        Wish wish = new Wish();
        wish.setMovieId(movieId);
        wish.setUserId(userId);
        return wishService.getUsersWishOfAMovie(wish);
    }

    @CheckToken
    @PostMapping("/wish")
    public RespBean makeWish(@RequestBody Wish wish) {
        return wishService.makeWish(wish);
    }

    @CheckToken
    @DeleteMapping("/wish/{wid}")
    public RespBean cancelWish(@PathVariable("wid") Integer wid) {
        return wishService.cancelWish(wid);
    }

}
