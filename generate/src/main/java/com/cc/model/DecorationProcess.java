package com.cc.model;

public class DecorationProcess {
    private Integer id;

    private String constructionTime;

    private String constructionContent;

    private String constructionPicUrls;

    private String remarks;

    private Integer contract_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConstructionTime() {
        return constructionTime;
    }

    public void setConstructionTime(String constructionTime) {
        this.constructionTime = constructionTime == null ? null : constructionTime.trim();
    }

    public String getConstructionContent() {
        return constructionContent;
    }

    public void setConstructionContent(String constructionContent) {
        this.constructionContent = constructionContent == null ? null : constructionContent.trim();
    }

    public String getConstructionPicUrls() {
        return constructionPicUrls;
    }

    public void setConstructionPicUrls(String constructionPicUrls) {
        this.constructionPicUrls = constructionPicUrls == null ? null : constructionPicUrls.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Integer getContract_id() {
        return contract_id;
    }

    public void setContract_id(Integer contract_id) {
        this.contract_id = contract_id;
    }
}