package com.example.listenenglish.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.listenenglish.R;
import com.example.listenenglish.adapter.ViewPagerBannerAdapter;
import com.example.listenenglish.model.QuangCao;
import com.example.listenenglish.service.APIRetrofitClient;
import com.example.listenenglish.service.APIService;
import com.example.listenenglish.service.DataService;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentBanner extends Fragment {
    View view;
    ViewPager viewPager;
    CircleIndicator circleIndicator;
    ViewPagerBannerAdapter viewPagerBannerAdapter;
    Runnable runnable;
    Handler handler;
    int currentItem;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_banner, container, false);
        anhXa();
        getData();
        return view;
    }

    private void anhXa() {
        viewPager = view.findViewById(R.id.vp_banner);
        circleIndicator = view.findViewById(R.id.cci_banner);
    }

    private void getData() {
        DataService dataService = APIService.getService();
        Call<List<QuangCao>> callback = dataService.getDataBanner();
        callback.enqueue(new Callback<List<QuangCao>>() {
            @Override
            public void onResponse(Call<List<QuangCao>> call, Response<List<QuangCao>> response) {
                // có kết quả trả về.
                ArrayList<QuangCao> banners = (ArrayList<QuangCao>) response.body();
                Log.d("Sang OK", "Banner OK " + banners.size());

                viewPagerBannerAdapter = new ViewPagerBannerAdapter(getContext(), banners);
                viewPager.setAdapter(viewPagerBannerAdapter);
                circleIndicator.setViewPager(viewPager);
                handler = new Handler();
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        currentItem = viewPager.getCurrentItem();
                        currentItem++;
                        if(currentItem >= viewPager.getAdapter().getCount())
                        {
                            currentItem = 0;
                        }
                        viewPager.setCurrentItem(currentItem,true);
                        handler.postDelayed(runnable,3000);
                    }

                };
                handler.postDelayed(runnable,3000);
            }

            @Override
            public void onFailure(Call<List<QuangCao>> call, Throwable t) {
                // thất bại, sai cấu trúc, không có kết quả.
                Log.d("Sang Failure", call.toString() + "/" +t.getMessage());
            }
        });
    }
}
