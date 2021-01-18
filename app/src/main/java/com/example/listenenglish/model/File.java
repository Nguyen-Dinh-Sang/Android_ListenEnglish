package com.example.listenenglish.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class File implements Parcelable {
    /// vừa obj vừa là mảng obj luôn

    @SerializedName("IdFile")
    @Expose
    private String idFile;
    @SerializedName("IdKhoaHoc")
    @Expose
    private String idKhoaHoc;
    @SerializedName("IdBaiHoc")
    @Expose
    private String idBaiHoc;
    @SerializedName("Mp3")
    @Expose
    private String mp3;
    @SerializedName("TenFile")
    @Expose
    private String tenFile;
    @SerializedName("NoiDung")
    @Expose
    private String noiDung;
    @SerializedName("IconFile")
    @Expose
    private String iconFile;
    @SerializedName("MoTa")
    @Expose
    private String moTa;
    @SerializedName("Like")
    @Expose
    private String like;

    protected File(Parcel in) {
        idFile = in.readString();
        idKhoaHoc = in.readString();
        idBaiHoc = in.readString();
        mp3 = in.readString();
        tenFile = in.readString();
        noiDung = in.readString();
        iconFile = in.readString();
        moTa = in.readString();
        like = in.readString();
    }

    public static final Creator<File> CREATOR = new Creator<File>() {
        @Override
        public File createFromParcel(Parcel in) {
            return new File(in);
        }

        @Override
        public File[] newArray(int size) {
            return new File[size];
        }
    };

    public String getIdFile() {
    return idFile;
    }

    public void setIdFile(String idFile) {
    this.idFile = idFile;
    }

    public String getIdKhoaHoc() {
    return idKhoaHoc;
    }

    public void setIdKhoaHoc(String idKhoaHoc) {
    this.idKhoaHoc = idKhoaHoc;
    }

    public String getIdBaiHoc() {
    return idBaiHoc;
    }

    public void setIdBaiHoc(String idBaiHoc) {
    this.idBaiHoc = idBaiHoc;
    }

    public String getMp3() {
    return mp3;
    }

    public void setMp3(String mp3) {
    this.mp3 = mp3;
    }

    public String getTenFile() {
    return tenFile;
    }

    public void setTenFile(String tenFile) {
    this.tenFile = tenFile;
    }

    public String getNoiDung() {
    return noiDung;
    }

    public void setNoiDung(String noiDung) {
    this.noiDung = noiDung;
    }

    public String getIconFile() {
    return iconFile;
    }

    public void setIconFile(String iconFile) {
    this.iconFile = iconFile;
    }

    public String getMoTa() {
    return moTa;
    }

    public void setMoTa(String moTa) {
    this.moTa = moTa;
    }

    public String getLike() {
    return like;
    }

    public void setLike(String like) {
    this.like = like;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(idFile);
        dest.writeString(idKhoaHoc);
        dest.writeString(idBaiHoc);
        dest.writeString(mp3);
        dest.writeString(tenFile);
        dest.writeString(noiDung);
        dest.writeString(iconFile);
        dest.writeString(moTa);
        dest.writeString(like);
    }
}