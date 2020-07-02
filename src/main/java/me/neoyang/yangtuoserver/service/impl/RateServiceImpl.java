package me.neoyang.yangtuoserver.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import me.neoyang.yangtuoserver.bean.Rate;
import me.neoyang.yangtuoserver.bean.RespBean;
import me.neoyang.yangtuoserver.dao.RateDao;
import me.neoyang.yangtuoserver.exception.MyException;
import me.neoyang.yangtuoserver.service.RateService;
import me.neoyang.yangtuoserver.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @name: RateServiceImpl
 * @desc:
 * @author: Zhaopeng Yang
 * @create: 2020-06-28 17:11
 **/
@Service
public class RateServiceImpl implements RateService {

    @Autowired
    private RateDao rateDao;


    @Override
    public RespBean getARateOfUser(Integer movieId, Integer userId) throws MyException {
        Rate rate = rateDao.selectByMovieIdAndUserId(movieId, userId);
        if (rate == null) {
            throw new MyException("用户尚未评价！");
        } else {
            return ResultUtil.success("查询成功", rate);
        }
    }

    @Override
    public List<Rate> getAllRates() {
        return rateDao.getAllRates();
    }

    @Override
    public RespBean getRateByMid(Integer movieId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(rateDao.getRateByMovieId(movieId));
        if (pageInfo.getTotal() == 0) {
            throw new MyException("电影不存在");
        }
        return ResultUtil.success(pageInfo);
    }

    @Override
    public RespBean makeRate(Rate rate) {
        try {
            Integer cid = rateDao.insertRate(rate);
            return ResultUtil.success("评论成功！", rate.getCid());
        } catch (Exception e) {
            e.printStackTrace();
            throw new MyException("评论失败！");
        }

    }

    @Override
    public RespBean deleteRate(Integer cid) {
        Integer rows = rateDao.delete(cid);
        System.out.println("delete rows " + rows);
        if (rows == 0) {
            throw new MyException("删除失败！");
        } else {
            return ResultUtil.success("删除成功", null);
        }
    }

    @Override
    public RespBean updateRate(Rate rate) {
        Integer rows = rateDao.update(rate);
        if (rows == 0) {
            throw new MyException("更新失败！");
        } else {
            return ResultUtil.success("更新成功");
        }
    }
}
