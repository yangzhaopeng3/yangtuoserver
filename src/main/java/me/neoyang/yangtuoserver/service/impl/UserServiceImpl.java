package me.neoyang.yangtuoserver.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    public RespBean whoAmI(HttpServletRequest request) {
        // 从 http 请求头中取出 token
        String token = request.getHeader("token");
        if (token == null) {
            throw new MyException(303, "无token，请重新登录");
        }
        // 获取 token 中的 user id
        String userId;
        try {
            userId = JWT.decode(token).getClaim("id").asString();
        } catch (JWTDecodeException j) {
            throw new MyException(304, "访问异常！");
        }
        User user = userDao.selectByPrimaryKey(Integer.parseInt(userId));
        if (user == null) {
            throw new MyException(301, "用户不存在，请重新登录");
        } else {
            return ResultUtil.success(user);
        }
    }

    @Override
    public RespBean login(User user, HttpServletResponse response) {
        User userLogin = userDao.findByUsername(user.getUsername());
        if (userLogin == null) {
            throw new MyException(301, "用户不存在！");
        } else if (!userLogin.getPassword().equals(EncryptUtil.encodeData(user.getPassword()))) {
            throw new MyException(302, "密码错误！");
        } else {
            String token = JwtUtil.createJWT(6000000, userLogin);
            response.setHeader("token", token);
            return ResultUtil.success("登录成功！", userLogin);
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
