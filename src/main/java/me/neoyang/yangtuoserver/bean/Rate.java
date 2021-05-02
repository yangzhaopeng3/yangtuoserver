package me.neoyang.yangtuoserver.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * @name: Rate
 * @desc:
 * @author: Zhaopeng Yang
 * @create: 2020-06-28 16:57
 **/
@JsonIgnoreProperties(value = {"handler"})
public class Rate implements Serializable {
    private Integer cid;
    private Integer movieId;
    private String comment;
    private Double rating;
    private Integer rateTime;
    private User user;

    public Rate() {
    }

    public Integer getRateTime() {
        return rateTime;
    }

    public void setRateTime(Integer rateTime) {
        this.rateTime = rateTime;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Rate{" +
                "cid=" + cid +
                ", movieId=" + movieId +
                ", comment='" + comment + '\'' +
                ", rating=" + rating +
                ", rateTime=" + rateTime +
                ", user=" + user +
                '}';
    }
}
