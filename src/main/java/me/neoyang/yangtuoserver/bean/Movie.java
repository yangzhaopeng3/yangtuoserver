package me.neoyang.yangtuoserver.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * @name: Movie
 * @desc: Movie的POJO类
 * @author: Zhaopeng Yang
 * @create: 2020-06-22 17:39
 **/
@JsonIgnoreProperties(value = {"handler"})
public class Movie implements Serializable {
    @JsonIgnore
    private Integer mid;
    private Integer movieId;
    private String movieTitle;
    private String titleOther;
    private String director;
    private String cast;
    private String country;
    private String genre;
    private String language;
    private Integer duration;
    private String description;
    private String releaseDate;
    private String tag;
    private String poster;
    private Double rating;
    private String doubanUrl;


    public Movie() {
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getTitleOther() {
        return titleOther;
    }

    public void setTitleOther(String titleOther) {
        this.titleOther = titleOther;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getDoubanUrl() {
        return doubanUrl;
    }

    public void setDoubanUrl(String doubanUrl) {
        this.doubanUrl = doubanUrl;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "mid=" + mid +
                ", movieId=" + movieId +
                ", movieTitle='" + movieTitle + '\'' +
                ", titleOther='" + titleOther + '\'' +
                ", director='" + director + '\'' +
                ", cast='" + cast + '\'' +
                ", country='" + country + '\'' +
                ", genre='" + genre + '\'' +
                ", language='" + language + '\'' +
                ", duration=" + duration +
                ", description='" + description + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", tag='" + tag + '\'' +
                ", poster='" + poster + '\'' +
                ", rating=" + rating +
                ", doubanUrl='" + doubanUrl + '\'' +
                '}';
    }
}
