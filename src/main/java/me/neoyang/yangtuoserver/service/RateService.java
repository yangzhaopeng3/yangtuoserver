package me.neoyang.yangtuoserver.service;

import me.neoyang.yangtuoserver.bean.Rate;

import java.util.List;

/**
 * @name: RateService
 * @desc:
 * @author: Zhaopeng Yang
 * @create: 2020-06-28 17:10
 **/
public interface RateService {

    List<Rate> getAllRates();

    List<Rate> getRateByMid(Integer movieId);

}
