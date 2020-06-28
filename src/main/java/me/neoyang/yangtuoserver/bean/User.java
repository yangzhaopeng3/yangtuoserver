package me.neoyang.yangtuoserver.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.smartcardio.CommandAPDU;
import java.io.Serializable;
import java.util.List;

/**
 * @name: User
 * @desc:
 * @author: Zhaopeng Yang
 * @create: 2020-06-28 16:56
 **/
@JsonIgnoreProperties(value = {"handler"})
public class User implements Serializable {
    private Integer userId;
    private String username;
    private String password;
    private String nickname;
    private String email;
    private List<Rate> ratings;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", ratings=" + ratings +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Rate> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rate> ratings) {
        this.ratings = ratings;
    }
}
