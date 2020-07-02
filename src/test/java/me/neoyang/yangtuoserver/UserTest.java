package me.neoyang.yangtuoserver;

import me.neoyang.yangtuoserver.bean.User;
import me.neoyang.yangtuoserver.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @name: MovieTest
 * @desc:
 * @author: Zhaopeng Yang
 * @create: 2020-06-22 21:20
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testUser1() {
        User user = new User();
        user.setNickname("nPEO");
        user.setPassword("12341");
        user.setUsername("123413413124");
        System.out.println(user);
        Integer integer = userDao.insertUser(user);
        System.out.println(integer);
        System.out.println(user);
    }

    @Test
    public void testUser2() {
        System.out.println(userDao.findByUsername("h3524123bcg"));
    }
}
