package me.neoyang.yangtuoserver.service;

import me.neoyang.yangtuoserver.bean.Rate;
import me.neoyang.yangtuoserver.bean.RespBean;

import java.util.List;

/**
 * @name: RateService
 * @desc:
 * @author: Zhaopeng Yang
 * @create: 2020-06-28 17:10
 **/
public interface RateService {

    List<Rate> getAllRates();

    RespBean getRateByMid(Integer movieId, Integer pageNum, Integer pageSize) throws Exception;

    RespBean makeRate(Rate rate) throws Exception;
}
