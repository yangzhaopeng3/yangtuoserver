package me.neoyang.yangtuoserver;

import me.neoyang.yangtuoserver.bean.User;
import me.neoyang.yangtuoserver.dao.UserDao;
import me.neoyang.yangtuoserver.service.UserService;
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

    @Autowired
    private UserService userService;

    @Test
    public void testUser1() {
        for (int i = 1; i <= 610; i++) {
            User user = new User();
            user.setNickname("测试用户" + i);
            user.setUsername("testuser" + i);
            user.setPassword("test123");
            user.setUserId(i);
            userService.register(user);
        }
    }

    @Test
    public void testUser2() {
        System.out.println(userDao.findByUsername("h3524123bcg"));
    }
}
