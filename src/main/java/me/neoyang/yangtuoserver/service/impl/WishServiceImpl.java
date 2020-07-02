package me.neoyang.yangtuoserver.service.impl;

import me.neoyang.yangtuoserver.bean.RespBean;
import me.neoyang.yangtuoserver.bean.Wish;
import me.neoyang.yangtuoserver.dao.WishDao;
import me.neoyang.yangtuoserver.exception.MyException;
import me.neoyang.yangtuoserver.service.WishService;
import me.neoyang.yangtuoserver.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @name: WishServiceImpl
 * @desc:
 * @author: Zhaopeng Yang
 * @create: 2020-07-02 13:28
 **/
@Service
public class WishServiceImpl implements WishService {

    @Autowired
    private WishDao wishDao;

    @Override
    public RespBean getUsersWishList(Integer userId) {
        List<Wish> wishes = wishDao.selectByUid(userId);
        if (wishes != null && wishes.size() != 0) {
            return ResultUtil.success(wishes);
        } else {
            throw new MyException("您还没有标记过想看信息呢");
        }
    }

    @Override
    public RespBean getUsersWishOfAMovie(Wish wish) {
        Wish userWish = wishDao.selectOneByMidAndUid(wish);
        if (userWish != null) {
            return ResultUtil.success(userWish);
        } else {
            throw new MyException("用户尚未标记想看");
        }
    }

    @Override
    public RespBean cancelWish(Integer wid) {
        Integer integer = wishDao.deleteWish(wid);
        if (integer == 0) {
            throw new MyException("取消想看失败！");
        } else {
            return ResultUtil.success(integer);
        }
    }

    @Override
    public RespBean makeWish(Wish wish) {
        Integer integer = wishDao.insertAWish(wish);
        if (integer != 0) {
            return ResultUtil.success("标记想看成功！", wish.getWid());
        } else {
            throw new MyException("标记失败！");
        }
    }
}
