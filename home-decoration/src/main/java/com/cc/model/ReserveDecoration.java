package com.cc.model;

import java.sql.Date;

public class ReserveDecoration {
    private Integer id;

    private String realname;

    private Long tel;

    private Boolean isdone;

    private Integer userid;

    private Date reservedate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    public Boolean getIsdone() {
        return isdone;
    }

    public void setIsdone(Boolean isdone) {
        this.isdone = isdone;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getReservedate() {
        return reservedate;
    }

    public void setReservedate(Date reservedate) {
        this.reservedate = reservedate;
    }

    public ReserveDecoration() {
    }

    @Override
    public String toString() {
        return "ReserveDecoration{" +
                "id=" + id +
                ", realname='" + realname + '\'' +
                ", tel=" + tel +
                ", isdone=" + isdone +
                ", userid=" + userid +
                ", reservedate=" + reservedate +
                '}';
    }
}