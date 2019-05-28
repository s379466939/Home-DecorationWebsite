package com.cc.model;

public class GalleryDesign {
    private Integer id;

    private String community;

    private String picurl;

    private String housetype;

    private Float area;

    private Float cost;

    private String style;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community == null ? null : community.trim();
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl == null ? null : picurl.trim();
    }

    public String getHousetype() {
        return housetype;
    }

    public void setHousetype(String housetype) {
        this.housetype = housetype == null ? null : housetype.trim();
    }

    public Float getArea() {
        return area;
    }

    public void setArea(Float area) {
        this.area = area;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style == null ? null : style.trim();
    }

    public GalleryDesign() {
    }

    public GalleryDesign(String community, String picurl, String housetype, Float area, Float cost, String style) {
        this.community = community;
        this.picurl = picurl;
        this.housetype = housetype;
        this.area = area;
        this.cost = cost;
        this.style = style;
    }

    @Override
    public String toString() {
        return "GalleryDesign{" +
                "id=" + id +
                ", community='" + community + '\'' +
                ", picurl='" + picurl + '\'' +
                ", housetype='" + housetype + '\'' +
                ", area=" + area +
                ", cost=" + cost +
                ", style='" + style + '\'' +
                '}';
    }
}