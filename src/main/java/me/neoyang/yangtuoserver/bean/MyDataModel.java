package me.neoyang.yangtuoserver.bean;


import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.model.JDBCDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class MyDataModel {

    @Autowired
    private DataSource dataSource;

    public static JDBCDataModel myDataModel() {
        MysqlDataSource dataSource = new MysqlDataSource();
        JDBCDataModel dataModel = null;
        try {
            dataSource.setServerName("localhost");
            dataSource.setPort(3306);
            dataSource.setCharacterEncoding("utf-8");
            dataSource.setUseSSL(false);
            dataSource.setServerTimezone("UTC");
            dataSource.setUser("root");
            dataSource.setPassword("456456asd");
            dataSource.setDatabaseName("yangtuo");
            dataModel = new MySQLJDBCDataModel(dataSource, "rating", "user_id", "movie_id", "rating", "rate_time");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataModel;
    }

    public MySQLJDBCDataModel getDataSource() {
        System.out.println(dataSource.getClass());
        return new MySQLJDBCDataModel(dataSource,
                "rating", "user_id",
                "movie_id", "rating", "rate_time");
    }
}
