package me.neoyang.yangtuoserver.controller;

import me.neoyang.yangtuoserver.bean.RespBean;
import me.neoyang.yangtuoserver.bean.User;
import me.neoyang.yangtuoserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @name: UserController
 * @desc:
 * @author: Zhaopeng Yang
 * @create: 2020-06-29 20:32
 **/

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public RespBean login(User user) throws Exception {
        return userService.login(user);
    }

    @PostMapping("/register")
    public RespBean register(User user) {
        return userService.register(user);
    }

}
