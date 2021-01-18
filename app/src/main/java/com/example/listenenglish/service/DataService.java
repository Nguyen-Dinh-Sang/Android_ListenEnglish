package com.example.listenenglish.service;

import com.example.listenenglish.model.BaiHoc;
import com.example.listenenglish.model.File;
import com.example.listenenglish.model.KhoaHoc;
import com.example.listenenglish.model.KhoaHocBaiHocToDay;
import com.example.listenenglish.model.QuangCao;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DataService {
    @GET("showquangcao.php")
    Call<List<QuangCao>> getDataBanner(); //thứ server trả về

    @GET("khoahoccurrentday.php")
    Call<List<KhoaHoc>> getKhoaHocToDay();

    @GET("khoahocbaihoc.php")
    Call<KhoaHocBaiHocToDay> getKhoaHocBaiHocToDay();

    @GET("baihochot.php")
    Call<List<BaiHoc>> getBaiHocHot();

    @GET("fileyeuthichnhat.php")
    Call<List<File>> getFileYeuThich();

    @FormUrlEncoded
    @POST("danhsachfile.php")
    Call<List<File>> getDanhSachFileTheoQuangCao(@Field("idquangcao") String idquangcao);

    @FormUrlEncoded
    @POST("danhsachfile.php")
    Call<List<File>> getDanhSachFileTheoKhoaHoc(@Field("idkhoahoc") String idkhoahoc);

    @GET("danhsachkhoahoc.php")
    Call<List<KhoaHoc>> getDanhSachKhoaHoc();

    @FormUrlEncoded
    @POST("danhsachfile.php")
    Call<List<File>> getDanhSachFileTheoBaiHoc(@Field("idbaihoc") String idbaihoc);

    @FormUrlEncoded
    @POST("baihoctheokhoahoc.php")
    Call<List<BaiHoc>> getDanhSachBaiHocTheoKhoaHoc(@Field("idkhoahoc") String idkhoahoc);

    @GET("baihoctheokhoahoc.php")
    Call<List<BaiHoc>> getDanhSachBaiHoc();

    @FormUrlEncoded
    @POST("updatelike.php")
    Call<String> updateLike(@Field("luotthich") String luotthich, @Field("idfile") String idfile);
}
