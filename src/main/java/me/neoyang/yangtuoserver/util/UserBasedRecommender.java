package me.neoyang.yangtuoserver.util;


import me.neoyang.yangtuoserver.bean.MyDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.CachingRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBasedRecommender {

    @Autowired
    private MyDataModel myDataModel;

    public List<RecommendedItem> recommendeByUser(Integer userId, int size) {
        // step:1 构建模型 2 计算相似度 3 查找k紧邻 4 构造推荐引擎
        List<RecommendedItem> recommendations = null;
        try {
            //构造数据模型
            DataModel model = myDataModel.getDataSource();
            //用PearsonCorrelation 算法计算用户相似度
            UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
            //计算用户的“邻居”，这里将与该用户最近距离为 3 的用户设置为该用户的“邻居”。
            UserNeighborhood neighborhood = new NearestNUserNeighborhood(3, similarity, model);
            //采用 CachingRecommender 为 RecommendationItem 进行缓存
            Recommender recommender = new CachingRecommender(new GenericUserBasedRecommender(model, neighborhood, similarity));
            //得到推荐的结果，size是推荐结果的数目
            recommendations = recommender.recommend(userId, size);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recommendations;
    }
}