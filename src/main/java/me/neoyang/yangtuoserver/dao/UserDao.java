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

    User getNickname(Integer userId);

    Integer insertUser(User user);

    User findByUsername(String username);

    User getUserByUsernameAndPassword(User user);

    User selectByPrimaryKey(Integer userId);
}
