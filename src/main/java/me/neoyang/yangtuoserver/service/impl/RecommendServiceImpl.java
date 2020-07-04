package me.neoyang.yangtuoserver.service.impl;

import me.neoyang.yangtuoserver.bean.RespBean;
import me.neoyang.yangtuoserver.dao.MovieDao;
import me.neoyang.yangtuoserver.service.RecommendService;
import me.neoyang.yangtuoserver.util.ItemBasedRecommender;
import me.neoyang.yangtuoserver.util.ResultUtil;
import me.neoyang.yangtuoserver.util.UserBasedRecommender;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @name: RecommendServiceImpl
 * @desc:
 * @author: Zhaopeng Yang
 * @create: 2020-07-03 22:34
 **/

@Service
public class RecommendServiceImpl implements RecommendService {


    @Autowired
    private UserBasedRecommender userBasedRecommender;

    @Autowired
    private ItemBasedRecommender itemBasedRecommender;

    @Autowired
    private MovieDao movieDao;

    @Override
    public RespBean recommendByItemBased(Integer userId, int size) {
        for (int i = 1; i < 300; i++) {
            System.out.println("processing " + i);
            List<RecommendedItem> recommendedItems = itemBasedRecommender.recommendByItem(i, size);
            if (recommendedItems.size() != 0) {
                for (RecommendedItem item : recommendedItems) {
                    movieDao.rec((int) item.getItemID(), i);
                }
            }
        }
        return null;
    }

    @Override
    public RespBean recommendByUserBased(Integer userId, int size) {
        List<RecommendedItem> recommendedItems = userBasedRecommender.recommendeByUser(userId, size);
        if (recommendedItems.size() == 0) {
            return ResultUtil.error(-1, "没有要推荐的东西！");
        } else {
            List<Long> movieIds = new ArrayList<>();
            for (RecommendedItem item : recommendedItems) {
                Long itemID = item.getItemID();
                movieIds.add(itemID);
            }
            return ResultUtil.success(movieDao.findRecommends(movieIds));
        }
    }
}
