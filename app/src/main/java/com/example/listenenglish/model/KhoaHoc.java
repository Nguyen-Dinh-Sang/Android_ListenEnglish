package com.example.listenenglish.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class KhoaHoc implements Serializable {

    @SerializedName("IdKhoaHoc")
    @Expose
    private String idKhoaHoc;
    @SerializedName("TenKhoaHoc")
    @Expose
    private String tenKhoaHoc;
    @SerializedName("IconKhoaHoc")
    @Expose
    private String iconKhoaHoc;
    @SerializedName("MoTa")
    @Expose
    private String moTa;

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

    public String getIconKhoaHoc() {
    return iconKhoaHoc;
    }

    public void setIconKhoaHoc(String iconKhoaHoc) {
    this.iconKhoaHoc = iconKhoaHoc;
    }

    public String getMoTa() {
    return moTa;
    }

    public void setMoTa(String moTa) {
    this.moTa = moTa;
    }

}