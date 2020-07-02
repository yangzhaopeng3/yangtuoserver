package me.neoyang.yangtuoserver.bean;

import java.io.Serializable;

/**
 * @name: Wish
 * @desc:
 * @author: Zhaopeng Yang
 * @create: 2020-07-02 13:14
 **/
public class Wish implements Serializable {
    private Integer wid;
    private Integer movieId;
    private Integer userId;

    public Wish() {
    }

    @Override
    public String toString() {
        return "Wish{" +
                "wid=" + wid +
                ", movieId=" + movieId +
                ", userId=" + userId +
                '}';
    }

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
