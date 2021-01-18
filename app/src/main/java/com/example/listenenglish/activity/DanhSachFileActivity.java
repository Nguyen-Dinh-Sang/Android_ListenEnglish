package com.example.listenenglish.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.listenenglish.R;
import com.example.listenenglish.adapter.DanhSachFileAdapter;
import com.example.listenenglish.model.BaiHoc;
import com.example.listenenglish.model.File;
import com.example.listenenglish.model.KhoaHoc;
import com.example.listenenglish.model.QuangCao;
import com.example.listenenglish.service.APIService;
import com.example.listenenglish.service.DataService;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhSachFileActivity extends AppCompatActivity {
    QuangCao quangCao;
    CoordinatorLayout coordinatorLayout;
    CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbar;
    RecyclerView recyclerView;
    FloatingActionButton floatingActionButton;
    ImageView imageView;
    ArrayList<File> fileArrayList;
    DanhSachFileAdapter adapter;
    KhoaHoc khoaHoc;
    BaiHoc baiHoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_file);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        dataIntent();
        mapping();
        initView();
        kiemTra();
        initEvent();
    }

    private void initEvent() {
        floatingActionButton.setEnabled(true);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DanhSachFileActivity.this, PlayActivity.class);
                intent.putExtra("danhsachfile", fileArrayList);
                startActivity(intent);
            }
        });
    }

    private void kiemTra() {
        if (quangCao != null && !quangCao.getIdQuangCao().equals("")) {
            setValueInView(quangCao.getTenFile(),quangCao.getIconQuangCao());
            getDataQuangCao(quangCao.getIdQuangCao());
        }

        if (khoaHoc != null && !khoaHoc.getIdKhoaHoc().equals("")) {
            setValueInView(khoaHoc.getTenKhoaHoc(), khoaHoc.getIconKhoaHoc());
            getDataKhoaHoc(khoaHoc.getIdKhoaHoc());
        }

        if (baiHoc != null && !baiHoc.getIdBaiHoc().equals("")) {
            setValueInView(baiHoc.getTenKhoaHoc(),baiHoc.getIConBaiHoc());
            getDataBaiHoc(baiHoc.getIdBaiHoc());
        }
    }

    private void getDataBaiHoc(String idBaiHoc) {
        DataService dataService = APIService.getService();
        Call<List<File>> callBack = dataService.getDanhSachFileTheoBaiHoc(idBaiHoc);
        callBack.enqueue(new Callback<List<File>>() {
            @Override
            public void onResponse(Call<List<File>> call, Response<List<File>> response) {
                fileArrayList = (ArrayList<File>) response.body();
                Log.d("Sang OK", "DanhSach_File_BaiHoc OK " + fileArrayList.size());
                adapter = new DanhSachFileAdapter(DanhSachFileActivity.this,fileArrayList);
                recyclerView.setLayoutManager(new LinearLayoutManager(DanhSachFileActivity.this));
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<File>> call, Throwable t) {

            }
        });
    }

    private void getDataKhoaHoc(String idKhoaHoc) {
        DataService dataService = APIService.getService();
        Call<List<File>> callBack = dataService.getDanhSachFileTheoKhoaHoc(idKhoaHoc);
        callBack.enqueue(new Callback<List<File>>() {
            @Override
            public void onResponse(Call<List<File>> call, Response<List<File>> response) {
                fileArrayList = (ArrayList<File>) response.body();
                Log.d("Sang OK", "DanhSach_File_KhoaHoc OK " + fileArrayList.size());
                adapter = new DanhSachFileAdapter(DanhSachFileActivity.this,fileArrayList);
                recyclerView.setLayoutManager(new LinearLayoutManager(DanhSachFileActivity.this));
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<File>> call, Throwable t) {

            }
        });
    }

    private void getDataQuangCao(String idQuangCao) {
        DataService dataService = APIService.getService();
        Call<List<File>> callBack = dataService.getDanhSachFileTheoQuangCao(idQuangCao);
        callBack.enqueue(new Callback<List<File>>() {
            @Override
            public void onResponse(Call<List<File>> call, Response<List<File>> response) {
                fileArrayList = (ArrayList<File>) response.body();
                Log.d("Sang OK", "DanhSach_File_QuangCao OK " + fileArrayList.size());
                adapter = new DanhSachFileAdapter(DanhSachFileActivity.this,fileArrayList);
                recyclerView.setLayoutManager(new LinearLayoutManager(DanhSachFileActivity.this));
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<File>> call, Throwable t) {

            }
        });
    }

    private void setValueInView(String tenFile, String hinh) {
        collapsingToolbarLayout.setTitle(tenFile);
        try {
            URL url = new URL(hinh);
            Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), bitmap);
            collapsingToolbarLayout.setBackground(bitmapDrawable);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Glide.with(this).load(hinh).into(imageView);
    }

    private void initView() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
        floatingActionButton.setEnabled(false);
    }

    private void mapping() {
        coordinatorLayout = findViewById(R.id.cdl_danhsach_file);
        collapsingToolbarLayout = findViewById(R.id.ctl_danhsach_file);
        toolbar = findViewById(R.id.tb_danhsach_file);
        recyclerView = findViewById(R.id.rv_danhsach_file);
        floatingActionButton = findViewById(R.id.fab_danhsach_flie);
        imageView = findViewById(R.id.iv_danhsach_file);
    }

    private void dataIntent() {
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("banner")) {
                quangCao = (QuangCao) intent.getSerializableExtra("banner");
            }

            if (intent.hasExtra("khoahoctoday")) {
                khoaHoc = (KhoaHoc) intent.getSerializableExtra("khoahoctoday");
            }

            if (intent.hasExtra("baihoc")) {
                baiHoc = (BaiHoc) intent.getSerializableExtra("baihoc");
            }
        }
    }
}
