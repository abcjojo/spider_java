package com.java.spider.entity;

import lombok.Data;

import java.io.Serializable;


@Data
public class TestSpiderDoubanmovietop250 implements Serializable {
    private Integer id;

    private String url;

    private String videoId;

    private String name;

    private Integer no;

    private Double score;

    private String type;

    private Integer number;

    private String director;

    private String scriptwriter;

    private String protagonists;

    private String quote;

    private String country;

    private String language;

    private String releaseDate;

    private Integer mins;

    private String alternateName;

    private String introduction;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId == null ? null : videoId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director == null ? null : director.trim();
    }

    public String getScriptwriter() {
        return scriptwriter;
    }

    public void setScriptwriter(String scriptwriter) {
        this.scriptwriter = scriptwriter == null ? null : scriptwriter.trim();
    }

    public String getProtagonists() {
        return protagonists;
    }

    public void setProtagonists(String protagonists) {
        this.protagonists = protagonists == null ? null : protagonists.trim();
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote == null ? null : quote.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate == null ? null : releaseDate.trim();
    }

    public Integer getMins() {
        return mins;
    }

    public void setMins(Integer mins) {
        this.mins = mins;
    }

    public String getAlternateName() {
        return alternateName;
    }

    public void setAlternateName(String alternateName) {
        this.alternateName = alternateName == null ? null : alternateName.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", url=").append(url);
        sb.append(", videoId=").append(videoId);
        sb.append(", name=").append(name);
        sb.append(", no=").append(no);
        sb.append(", score=").append(score);
        sb.append(", type=").append(type);
        sb.append(", number=").append(number);
        sb.append(", director=").append(director);
        sb.append(", scriptwriter=").append(scriptwriter);
        sb.append(", protagonists=").append(protagonists);
        sb.append(", quote=").append(quote);
        sb.append(", country=").append(country);
        sb.append(", language=").append(language);
        sb.append(", releaseDate=").append(releaseDate);
        sb.append(", mins=").append(mins);
        sb.append(", alternateName=").append(alternateName);
        sb.append(", introduction=").append(introduction);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}