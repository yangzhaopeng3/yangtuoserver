package me.neoyang.yangtuoserver.dao;

import me.neoyang.yangtuoserver.bean.Rate;
import me.neoyang.yangtuoserver.exception.MyException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @name: RateDao
 * @desc:
 * @author: Zhaopeng Yang
 * @create: 2020-06-28 17:00
 **/
@Repository
public interface RateDao {

    List<Rate> getAllRates() throws MyException;

    List<Rate> getRateByMovieId(Integer movieId) throws MyException;

    Integer insertRate(Rate rate) throws MyException;
}
