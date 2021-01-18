package com.example.listenenglish.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class QuangCao implements Serializable {

    @SerializedName("IdQuangCao")
    @Expose
    private String idQuangCao;
    @SerializedName("IconQuangCao")
    @Expose
    private String iconQuangCao;
    @SerializedName("NoiDung")
    @Expose
    private String noiDung;
    @SerializedName("IdFile")
    @Expose
    private String idFile;
    @SerializedName("TenFile")
    @Expose
    private String tenFile;
    @SerializedName("IconFile")
    @Expose
    private String iconFile;

    public String getIdQuangCao() {
    return idQuangCao;
    }

    public void setIdQuangCao(String idQuangCao) {
    this.idQuangCao = idQuangCao;
    }

    public String getIconQuangCao() {
    return iconQuangCao;
    }

    public void setIconQuangCao(String iconQuangCao) {
    this.iconQuangCao = iconQuangCao;
    }

    public String getNoiDung() {
    return noiDung;
    }

    public void setNoiDung(String noiDung) {
    this.noiDung = noiDung;
    }

    public String getIdFile() {
    return idFile;
    }

    public void setIdFile(String idFile) {
    this.idFile = idFile;
    }

    public String getTenFile() {
    return tenFile;
    }

    public void setTenFile(String tenFile) {
    this.tenFile = tenFile;
    }

    public String getIconFile() {
    return iconFile;
    }

    public void setIconFile(String iconFile) {
this.iconFile = iconFile;
}

}