package me.neoyang.yangtuoserver.bean;

/**
 * @name: Tag
 * @desc:
 * @author: Zhaopeng Yang
 * @create: 2020-07-03 01:12
 **/
public class Tag {
    private String type;
    private String region;
    private String year;
    private String special;

    public Tag() {
    }

    @Override
    public String toString() {
        return "Tag{" +
                "type='" + type + '\'' +
                ", region='" + region + '\'' +
                ", year='" + year + '\'' +
                ", special='" + special + '\'' +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }
}
