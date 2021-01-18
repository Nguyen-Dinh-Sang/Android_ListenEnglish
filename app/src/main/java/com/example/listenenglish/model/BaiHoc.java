package com.example.listenenglish.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BaiHoc implements Serializable {
    // gửi dưới dạng object

    @SerializedName("IdBaiHoc")
    @Expose
    private String idBaiHoc;
    @SerializedName("IdKhoaHoc")
    @Expose
    private String idKhoaHoc;
    @SerializedName("TenKhoaHoc")
    @Expose
    private String tenKhoaHoc;
    @SerializedName("IConBaiHoc")
    @Expose
    private String iConBaiHoc;
    @SerializedName("MoTa")
    @Expose
    private String moTa;

    public String getIdBaiHoc() {
    return idBaiHoc;
    }

    public void setIdBaiHoc(String idBaiHoc) {
    this.idBaiHoc = idBaiHoc;
    }

    public String getIdKhoaHoc() {
    return idKhoaHoc;
    }

    public void setIdKhoaHoc(String idKhoaHoc) {
    this.idKhoaHoc = idKhoaHoc;
    }

    public String getTenKhoaHoc() {
    return tenKhoaHoc;
    }

    public void setTenKhoaHoc(String tenKhoaHoc) {
    this.tenKhoaHoc = tenKhoaHoc;
    }

    public String getIConBaiHoc() {
    return iConBaiHoc;
    }

    public void setIConBaiHoc(String iConBaiHoc) {
    this.iConBaiHoc = iConBaiHoc;
    }

    public String getMoTa() {
    return moTa;
    }

    public void setMoTa(String moTa) {
    this.moTa = moTa;
    }

}