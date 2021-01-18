package com.example.listenenglish.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;

import com.example.listenenglish.R;
import com.example.listenenglish.adapter.DanhSachBaiHocAdapter;
import com.example.listenenglish.model.BaiHoc;
import com.example.listenenglish.model.KhoaHoc;
import com.example.listenenglish.model.QuangCao;
import com.example.listenenglish.service.APIService;
import com.example.listenenglish.service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhSachBaiHocActivity extends AppCompatActivity {
    KhoaHoc khoaHoc;
    Toolbar toolbar;
    RecyclerView recyclerView;
    ArrayList<BaiHoc> baiHocArrayList;
    DanhSachBaiHocAdapter danhSachBaiHocAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_bai_hoc);
        //tránh tình trạng phát sinh khi sử dụng mạng
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        dataIntent();
        initView();
        kiemTra();
    }

    private void kiemTra() {
        if (khoaHoc != null && !khoaHoc.getIdKhoaHoc().equals("")) {
            getDataBaiHocTheoKhoaHoc(khoaHoc.getIdKhoaHoc());
        } else {
            getDataAllBaiHoc();
        }
    }

    private void getDataBaiHocTheoKhoaHoc(String idKhoaHoc) {
        DataService dataService = APIService.getService();
        Call<List<BaiHoc>> callBack = dataService.getDanhSachBaiHocTheoKhoaHoc(idKhoaHoc);
        callBack.enqueue(new Callback<List<BaiHoc>>() {
            @Override
            public void onResponse(Call<List<BaiHoc>> call, Response<List<BaiHoc>> response) {
                baiHocArrayList = (ArrayList<BaiHoc>) response.body();
                Log.d("Sang OK", "DanhSach_BaiHoc_KhoaHoc OK " + baiHocArrayList.size());

                danhSachBaiHocAdapter = new DanhSachBaiHocAdapter(DanhSachBaiHocActivity.this, baiHocArrayList);

                recyclerView.setLayoutManager(new GridLayoutManager(DanhSachBaiHocActivity.this, 2));
                recyclerView.setAdapter(danhSachBaiHocAdapter);
            }

            @Override
            public void onFailure(Call<List<BaiHoc>> call, Throwable t) {

            }
        });
    }

    private void getDataAllBaiHoc() {
        DataService dataService = APIService.getService();
        Call<List<BaiHoc>> callBack = dataService.getDanhSachBaiHoc();
        callBack.enqueue(new Callback<List<BaiHoc>>() {
            @Override
            public void onResponse(Call<List<BaiHoc>> call, Response<List<BaiHoc>> response) {
                baiHocArrayList = (ArrayList<BaiHoc>) response.body();
                Log.d("Sang OK", "DanhSach_BaiHoc OK " + baiHocArrayList.size());

                danhSachBaiHocAdapter = new DanhSachBaiHocAdapter(DanhSachBaiHocActivity.this, baiHocArrayList);

                recyclerView.setLayoutManager(new GridLayoutManager(DanhSachBaiHocActivity.this, 2));
                recyclerView.setAdapter(danhSachBaiHocAdapter);
            }

            @Override
            public void onFailure(Call<List<BaiHoc>> call, Throwable t) {

            }
        });
    }

    private void initView() {
        recyclerView = findViewById(R.id.rv_danhsach_baihoc);
        toolbar = findViewById(R.id.tb_danhsach_baihoc);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (khoaHoc != null) {
            getSupportActionBar().setTitle(khoaHoc.getTenKhoaHoc());
        } else {
            getSupportActionBar().setTitle("Tất Cả Các Bài Học");
        }
        toolbar.setTitleTextColor(getResources().getColor(R.color.mau_tim));
        toolbar.setBackgroundColor(getResources().getColor(R.color.mau_xanh));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void dataIntent() {
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("khoahoc")) {
                khoaHoc = (KhoaHoc) intent.getSerializableExtra("khoahoc");
            }
        }
    }
}
