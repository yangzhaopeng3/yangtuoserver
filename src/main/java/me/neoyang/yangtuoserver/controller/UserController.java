package me.neoyang.yangtuoserver.controller;

import me.neoyang.yangtuoserver.bean.RespBean;
import me.neoyang.yangtuoserver.bean.User;
import me.neoyang.yangtuoserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
