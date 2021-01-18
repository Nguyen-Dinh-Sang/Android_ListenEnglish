package com.example.listenenglish.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;

import com.example.listenenglish.R;
import com.example.listenenglish.adapter.DanhSachKhoaHocAdapter;
import com.example.listenenglish.model.KhoaHoc;
import com.example.listenenglish.service.APIService;
import com.example.listenenglish.service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhSachKhoaHocActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    DanhSachKhoaHocAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_khoa_hoc);
        //tránh tình trạng phát sinh khi sử dụng mạng
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        mapping();
        initView();
        getData();
    }

    private void initView() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Các Khóa Học");
        toolbar.setTitleTextColor(getResources().getColor(R.color.mau_tim));
        toolbar.setBackgroundColor(getResources().getColor(R.color.mau_xanh));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void getData() {
        DataService dataService = APIService.getService();
        Call<List<KhoaHoc>> callBack = dataService.getDanhSachKhoaHoc();
        callBack.enqueue(new Callback<List<KhoaHoc>>() {
            @Override
            public void onResponse(Call<List<KhoaHoc>> call, Response<List<KhoaHoc>> response) {
                ArrayList<KhoaHoc> khoaHocArrayList = (ArrayList<KhoaHoc>) response.body();
                Log.d("Sang OK", "DanhSach_KhoaHoc OK " + khoaHocArrayList.size());

                adapter = new DanhSachKhoaHocAdapter(DanhSachKhoaHocActivity.this, khoaHocArrayList);
                recyclerView.setLayoutManager(new GridLayoutManager(DanhSachKhoaHocActivity.this,2));
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<KhoaHoc>> call, Throwable t) {

            }
        });
    }

    private void mapping() {
        toolbar = findViewById(R.id.tb_danhsach_khoahoc);
        recyclerView = findViewById(R.id.rv_danhsach_khoahoc);
    }
}
