package me.neoyang.yangtuoserver.service.impl;

import me.neoyang.yangtuoserver.bean.Movie;
import me.neoyang.yangtuoserver.bean.RespBean;
import me.neoyang.yangtuoserver.dao.RecDao;
import me.neoyang.yangtuoserver.exception.MyException;
import me.neoyang.yangtuoserver.service.RecService;
import me.neoyang.yangtuoserver.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @name: RecServiceImpl
 * @desc:
 * @author: Zhaopeng Yang
 * @create: 2021-04-26 14:23
 **/
@Service
public class RecServiceImpl implements RecService {


    @Autowired
    private RecDao recDao;


    @Override
    public RespBean recMovie2User(Integer userId) {
        List<Movie> movies = recDao.recMovie2User(userId);
        if (movies.size() == 0) {
            throw new MyException("没有要推荐的电影哦！");
        }
        return ResultUtil.success("推荐成功", movies);
    }

    @Override
    public RespBean recMovie2Movie(Integer movieId) {
        List<Movie> movies = recDao.recMovie2Movie(movieId);
        if (movies.size() == 0) {
            throw new MyException("没有要推荐的电影哦！");
        }
        return ResultUtil.success("查推荐成功询成功", movies);
    }
}
