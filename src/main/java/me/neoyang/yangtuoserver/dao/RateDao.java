package me.neoyang.yangtuoserver.dao;

import me.neoyang.yangtuoserver.bean.Rate;
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

    public List<Rate> getAllRates();

    public List<Rate> getRateByMovieId(Integer movieId);
}
