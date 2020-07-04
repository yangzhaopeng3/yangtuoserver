package me.neoyang.yangtuoserver.controller;

import me.neoyang.yangtuoserver.bean.CheckToken;
import me.neoyang.yangtuoserver.bean.RespBean;
import me.neoyang.yangtuoserver.bean.User;
import me.neoyang.yangtuoserver.service.RecommendService;
import me.neoyang.yangtuoserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @name: UserController
 * @desc:
 * @author: Zhaopeng Yang
 * @create: 2020-06-29 20:32
 **/

@RestController
public class UserController {

    @Autowired
    private RecommendService recommendService;

    /*@Autowired
    private UserBasedRecommender userBasedRecommender;*/

    @CheckToken
    @GetMapping("/suggest/{userId}")
    public RespBean recommendeByItem(@PathVariable("userId") Integer userId) {
        System.out.println("再推荐中！!");
        return recommendService.recommendByUserBased(userId, 12);
    }

    /*@GetMapping("/test")
    public RespBean serveRec() {
        System.out.println("处理中！!");
        return recommendService.recommendByItemBased(1, 12);
    }*/


    @Autowired
    private UserService userService;

    @GetMapping("/whoami")
    public RespBean getWhoAmI(HttpServletRequest request) {
        return userService.whoAmI(request);
    }


    @PostMapping("/login")
    public RespBean login(@RequestBody User user, HttpServletResponse response) throws Exception {
        return userService.login(user, response);
    }

    @PostMapping("/register")
    public RespBean register(@RequestBody User user) {
        System.out.println(user);
        return userService.register(user);
    }

}
