package me.neoyang.yangtuoserver.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import me.neoyang.yangtuoserver.bean.Movie;
import me.neoyang.yangtuoserver.bean.RespBean;
import me.neoyang.yangtuoserver.dao.MovieDao;
import me.neoyang.yangtuoserver.exception.MyException;
import me.neoyang.yangtuoserver.service.MovieService;
import me.neoyang.yangtuoserver.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @name: MovieServiceImpl
 * @desc:
 * @author: Zhaopeng Yang
 * @create: 2020-06-22 17:50
 **/

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieDao movieDao;

    @Override
    public RespBean getMoviebyTag(HashMap map) {
        PageHelper.startPage(Integer.valueOf((String) map.get("start")), Integer.valueOf((String) map.get("limit")));
        PageInfo pageInfo = new PageInfo(movieDao.selectByTag(map));
        if (pageInfo.getTotal() == 0) {
            throw new MyException("找不到资源");
        }
        return ResultUtil.success("查询成功", pageInfo);
    }

    @Override
    public RespBean getMoviesOrderByRate(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(movieDao.getMovieListOrderByRate());
        if (pageInfo.getTotal() == 0) {
            throw new MyException("找不到资源");
        }
        return ResultUtil.success("查询成功", pageInfo);
    }

    @Override
    public RespBean search(String content, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(movieDao.search(content));
        if (pageInfo.getTotal() == 0) {
            throw new MyException("找不到资源");
        }
        return ResultUtil.success("查询成功", pageInfo);
    }

    @Override
    public RespBean getWatchedList(Integer userId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(movieDao.getWatchedList(userId));
        if (pageInfo.getTotal() == 0) {
            throw new MyException("您还没看过任何电影");
        }
        return ResultUtil.success("查询成功", pageInfo);
    }

    @Override
    public RespBean getWishList(Integer userId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(movieDao.getWishList(userId));
        if (pageInfo.getTotal() == 0) {
            throw new MyException("您还没想看过任何电影");
        }
        return ResultUtil.success("查询成功", pageInfo);
    }

    @Override
    public RespBean getMovieById(Integer movieId) throws MyException {
        Movie movie = movieDao.getMovieById(movieId);
        if (movie == null) {
            throw new MyException("找不到资源");
        }
        return ResultUtil.success("查询成功", movie);
    }

    @Override
    public RespBean getMovies(Integer pageNum, Integer pageSize) throws MyException {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(movieDao.getMovieList());
        if (pageInfo.getTotal() == 0) {
            throw new MyException("找不到资源");
        }
        return ResultUtil.success("查询成功", pageInfo);
    }
}
