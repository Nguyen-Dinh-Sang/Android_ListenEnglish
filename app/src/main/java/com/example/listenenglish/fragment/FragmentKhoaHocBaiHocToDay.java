package com.example.listenenglish.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.listenenglish.R;
import com.example.listenenglish.activity.DanhSachBaiHocActivity;
import com.example.listenenglish.activity.DanhSachFileActivity;
import com.example.listenenglish.activity.DanhSachKhoaHocBaiHocActivity;
import com.example.listenenglish.adapter.KhoaHocToDayAdapter;
import com.example.listenenglish.model.BaiHoc;
import com.example.listenenglish.model.KhoaHoc;
import com.example.listenenglish.model.KhoaHocBaiHocToDay;
import com.example.listenenglish.service.APIService;
import com.example.listenenglish.service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentKhoaHocBaiHocToDay extends Fragment {
    View view;
    HorizontalScrollView horizontalScrollView;
    TextView textViewXemThem;
            
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_khoahoc_baihoc_today,container,false);
        anhXa();
        initEvent();
        getData();
        return view;
    }

    private void initEvent() {
        textViewXemThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DanhSachKhoaHocBaiHocActivity.class);
                startActivity(intent);
            }
        });
    }

    private void anhXa() {
        horizontalScrollView = view.findViewById(R.id.hs_khoahoc_baihoc);
        textViewXemThem = view.findViewById(R.id.tv_xemthem);
    }

    private void getData() {
        DataService dataService = APIService.getService();
        Call<KhoaHocBaiHocToDay> callBack = dataService.getKhoaHocBaiHocToDay();
        callBack.enqueue(new Callback<KhoaHocBaiHocToDay>() {
            @Override
            public void onResponse(Call<KhoaHocBaiHocToDay> call, Response<KhoaHocBaiHocToDay> response) {
                KhoaHocBaiHocToDay khoaHocBaiHocToDay = response.body();
                Log.d("Sang OK", "KhoaHoc_BaiHoc OK " + khoaHocBaiHocToDay.getKhoaHoc().size() + "/" + khoaHocBaiHocToDay.getBaiHoc().size());

                final ArrayList<KhoaHoc> arrayListKhoaHoc = new ArrayList<>();
                arrayListKhoaHoc.addAll(khoaHocBaiHocToDay.getKhoaHoc());
                final ArrayList<BaiHoc> arrayListBaiHoc = new ArrayList<>();
                arrayListBaiHoc.addAll(khoaHocBaiHocToDay.getBaiHoc());

                LinearLayout linearLayout = new LinearLayout(getActivity());
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(580, 250);
                layoutParams.setMargins(10, 20, 10, 30);

                for (int i = 0; i < arrayListKhoaHoc.size(); i++) {
                    CardView cardView = new CardView(getActivity());
                    cardView.setRadius(10);

                    ImageView imageView = new ImageView(getActivity());
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);

                    TextView textViewTen = new TextView(getActivity());
                    textViewTen.setTextSize(25);
                    textViewTen.setMaxLines(1);
                    textViewTen.setPadding(20,20,50,50);
                    textViewTen.setTextColor(getResources().getColor(R.color.colorTextTenKhoaHocBaiHoc));

                    if (arrayListKhoaHoc.get(i).getIconKhoaHoc() != null) {
                        Glide.with(getActivity()).load(arrayListKhoaHoc.get(i).getIconKhoaHoc()).into(imageView);
                        textViewTen.setText(arrayListKhoaHoc.get(i).getTenKhoaHoc());
                    }

                    cardView.setLayoutParams(layoutParams);
                    cardView.addView(imageView);
                    cardView.addView(textViewTen);

                    linearLayout.addView(cardView);

                    final int finalI = i;
                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getActivity(), DanhSachBaiHocActivity.class);
                            intent.putExtra("khoahoc", arrayListKhoaHoc.get(finalI));
                            startActivity(intent);
                        }
                    });
                }
                for (int i = 0; i < arrayListBaiHoc.size(); i++) {
                    CardView cardView = new CardView(getActivity());
                    cardView.setRadius(10);

                    ImageView imageView = new ImageView(getActivity());
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);

                    TextView textViewTen = new TextView(getActivity());
                    textViewTen.setTextSize(25);
                    textViewTen.setMaxLines(1);
                    textViewTen.setPadding(20,20,50,50);
                    textViewTen.setTextColor(getResources().getColor(R.color.colorTextTenKhoaHocBaiHoc));

                    if (arrayListBaiHoc.get(i).getIConBaiHoc() != null) {
                        Glide.with(getActivity()).load(arrayListBaiHoc.get(i).getIConBaiHoc()).into(imageView);
                        textViewTen.setText(arrayListBaiHoc.get(i).getTenKhoaHoc());
                    }

                    cardView.setLayoutParams(layoutParams);
                    cardView.addView(imageView);
                    cardView.addView(textViewTen);

                    linearLayout.addView(cardView);

                    final int finalI = i;
                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getActivity(), DanhSachFileActivity.class);
                            intent.putExtra("baihoc", arrayListBaiHoc.get(finalI));
                            startActivity(intent);
                        }
                    });
                }

                horizontalScrollView.addView(linearLayout);
            }

            @Override
            public void onFailure(Call<KhoaHocBaiHocToDay> call, Throwable t) {

            }
        });
    }
}
