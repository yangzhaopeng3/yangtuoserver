package me.neoyang.yangtuoserver.dao;

import me.neoyang.yangtuoserver.bean.Wish;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @name: WishDao
 * @desc:
 * @author: Zhaopeng Yang
 * @create: 2020-07-02 13:18
 **/

@Repository
public interface WishDao {

    List<Wish> selectByUid(Integer userId);

    Wish selectOneByMidAndUid(Wish wish);

    Integer insertAWish(Wish wish);

    Integer deleteWish(Integer wid);

}
