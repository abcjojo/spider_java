package com.java.spider.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;


@Getter
@Setter
@ToString
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

}