package me.neoyang.yangtuoserver.dao;

import me.neoyang.yangtuoserver.bean.User;
import org.springframework.stereotype.Repository;

/**
 * @name: UserDao
 * @desc:
 * @author: Zhaopeng Yang
 * @create: 2020-06-28 17:04
 **/
@Repository
public interface UserDao {

    public User findUserByUserId(Integer userId);

    public User getNickname(Integer userId);

}
