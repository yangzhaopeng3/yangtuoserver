package me.neoyang.yangtuoserver.service.impl;

import me.neoyang.yangtuoserver.bean.RespBean;
import me.neoyang.yangtuoserver.bean.User;
import me.neoyang.yangtuoserver.dao.UserDao;
import me.neoyang.yangtuoserver.exception.MyException;
import me.neoyang.yangtuoserver.service.UserService;
import me.neoyang.yangtuoserver.util.EncryptUtil;
import me.neoyang.yangtuoserver.util.JwtUtil;
import me.neoyang.yangtuoserver.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @name: UserServiceImpl
 * @desc:
 * @author: Zhaopeng Yang
 * @create: 2020-06-29 20:32
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public RespBean login(User user) {
        User userLogin = userDao.findByUsername(user.getUsername());
        if (userLogin == null) {
            throw new MyException(301, "用户不存在！");
        } else if (!userLogin.getPassword().equals(EncryptUtil.encodeData(user.getPassword()))) {
            throw new MyException(302, "密码错误！");
        } else {
            String token = JwtUtil.createJWT(6000000, userLogin);
            HashMap map = new HashMap();
            map.put("token", token);
            return ResultUtil.success("登录成功！", map);
        }
    }

    @Override
    public RespBean register(User user) {
        User userExisted = userDao.findByUsername(user.getUsername());
        if (userExisted != null) {
            throw new MyException("用户名已被注册！");
        } else {
            user.setPassword(EncryptUtil.encodeData(user.getPassword()));
            userDao.insertUser(user);
            return ResultUtil.success("注册成功");
        }
    }
}
