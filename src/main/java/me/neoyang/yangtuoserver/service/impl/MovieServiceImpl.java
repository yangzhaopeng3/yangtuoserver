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
