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
            return ResultUtil.success("评论成功！", cid);
        } catch (Exception e) {
            throw new MyException("评论失败！");
        }

    }
}
