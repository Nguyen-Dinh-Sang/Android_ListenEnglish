package com.example.listenenglish.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.StrictMode;

import com.example.listenenglish.R;
import com.example.listenenglish.adapter.ViewPagerMainAdapter;
import com.example.listenenglish.fragment.FragmentTimKiem;
import com.example.listenenglish.fragment.FragmentTrangChu;
import com.google.android.material.tabs.TabLayout;

import static android.util.Log.d;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //tránh tình trạng phát sinh khi sử dụng mạng
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        initView();
        initEvent();
        initData();
    }

    private void initData() {

    }

    private void initEvent() {

    }

    private void initView() {
        tabLayout = findViewById(R.id.tl_main);
        viewPager = findViewById(R.id.vp_main);

        ViewPagerMainAdapter adapter = new ViewPagerMainAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentTrangChu(), "Trang Chủ");
        adapter.addFragment(new FragmentTimKiem(), "Tìm Kiếm");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_search);
    }
}
