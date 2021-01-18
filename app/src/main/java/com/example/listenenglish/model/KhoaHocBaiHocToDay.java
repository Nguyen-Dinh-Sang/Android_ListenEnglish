package com.example.listenenglish.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KhoaHocBaiHocToDay {

@SerializedName("KhoaHoc")
@Expose
private List<KhoaHoc> khoaHoc = null;
@SerializedName("BaiHoc")
@Expose
private List<BaiHoc> baiHoc = null;

public List<KhoaHoc> getKhoaHoc() {
return khoaHoc;
}

public void setKhoaHoc(List<KhoaHoc> khoaHoc) {
this.khoaHoc = khoaHoc;
}

public List<BaiHoc> getBaiHoc() {
return baiHoc;
}

public void setBaiHoc(List<BaiHoc> baiHoc) {
this.baiHoc = baiHoc;
}

}