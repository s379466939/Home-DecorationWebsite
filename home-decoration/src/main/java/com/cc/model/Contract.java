package com.cc.model;

public class Contract {
    private Integer id;

    private Integer userid;


    private String username;

    private String merchant;

    private String contractcontent;

    private String houselocation;

    private String housedescription;

    private String constructiontime;

    private Boolean contractstate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant == null ? null : merchant.trim();
    }

    public String getContractcontent() {
        return contractcontent;
    }

    public void setContractcontent(String contractcontent) {
        this.contractcontent = contractcontent == null ? null : contractcontent.trim();
    }

    public String getHouselocation() {
        return houselocation;
    }

    public void setHouselocation(String houselocation) {
        this.houselocation = houselocation == null ? null : houselocation.trim();
    }

    public String getHousedescription() {
        return housedescription;
    }

    public void setHousedescription(String housedescription) {
        this.housedescription = housedescription == null ? null : housedescription.trim();
    }

    public String getConstructiontime() {
        return constructiontime;
    }

    public void setConstructiontime(String constructiontime) {
        this.constructiontime = constructiontime == null ? null : constructiontime.trim();
    }

    public Boolean getContractstate() {
        return contractstate;
    }

    public void setContractstate(Boolean contractstate) {
        this.contractstate = contractstate;
    }

}