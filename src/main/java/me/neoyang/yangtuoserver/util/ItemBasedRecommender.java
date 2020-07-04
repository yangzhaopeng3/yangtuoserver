package me.neoyang.yangtuoserver.util;

import me.neoyang.yangtuoserver.bean.MyDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemBasedRecommender {

    @Autowired
    private MyDataModel myDataModel;

    public List<RecommendedItem> recommendByItem(Integer userId, int size) {
        List<RecommendedItem> recommendations = null;
        try {
            //构造数据模型
            DataModel model = myDataModel.getDataSource();
            //计算内容相似度
            ItemSimilarity similarity = new PearsonCorrelationSimilarity(model);
            //构造推荐引擎
            Recommender recommender = new GenericItemBasedRecommender(model, similarity);
            //得到推荐结果
            recommendations = recommender.recommend(userId, size);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recommendations;
    }
}
