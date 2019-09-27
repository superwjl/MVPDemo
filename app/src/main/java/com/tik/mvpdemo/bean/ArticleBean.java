package com.tik.mvpdemo.bean;

public class ArticleBean {


    /**
     * "id":"2395248880_2653703605_1",
     * "title":"爱上处女座=送人头",
     * "source":"処女座的运势",
     * "firstImg":"",
     * "mark":"",
     */

    private String firstImg;
    private String id;
    private String mark;
    private String source;
    private String title;

    public String getFirstImg() {
        return firstImg;
    }

    public void setFirstImg(String firstImg) {
        this.firstImg = firstImg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "ArticleBean{" +
                "firstImg='" + firstImg + '\'' +
                ", id='" + id + '\'' +
                ", mark='" + mark + '\'' +
                ", source='" + source + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}