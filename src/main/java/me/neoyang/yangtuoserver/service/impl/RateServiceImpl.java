package me.neoyang.yangtuoserver.service.impl;

import me.neoyang.yangtuoserver.bean.Rate;
import me.neoyang.yangtuoserver.dao.RateDao;
import me.neoyang.yangtuoserver.service.RateService;
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
    public List<Rate> getRateByMid(Integer movieId) {
        return rateDao.getRateByMovieId(movieId);
    }
}
