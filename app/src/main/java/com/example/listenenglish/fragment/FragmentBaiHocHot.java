package com.example.listenenglish.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listenenglish.R;
import com.example.listenenglish.activity.DanhSachBaiHocActivity;
import com.example.listenenglish.activity.DanhSachFileActivity;
import com.example.listenenglish.adapter.BaiHocAdapter;
import com.example.listenenglish.model.BaiHoc;
import com.example.listenenglish.service.APIService;
import com.example.listenenglish.service.DataService;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentBaiHocHot extends Fragment {
    View view;
    RecyclerView recyclerViewBaiHocHot;
    TextView textViewXemThem;
    BaiHocAdapter baiHocAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_baihoc_hot,container,false);
        anhXa();
        initEvent();
        getData();
        return view;
    }

    private void initEvent() {
        textViewXemThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DanhSachBaiHocActivity.class);
                startActivity(intent);
            }
        });
    }

    private void getData() {
        DataService dataService = APIService.getService();
        Call<List<BaiHoc>> callBack = dataService.getBaiHocHot();
        callBack.enqueue(new Callback<List<BaiHoc>>() {
            @Override
            public void onResponse(Call<List<BaiHoc>> call, Response<List<BaiHoc>> response) {
                ArrayList<BaiHoc> baiHocArrayList = (ArrayList<BaiHoc>) response.body();
                Log.d("Sang OK", "BaiHoc_Hot OK " + baiHocArrayList.size());

                baiHocAdapter = new BaiHocAdapter(getActivity(), baiHocArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerViewBaiHocHot.setLayoutManager(linearLayoutManager);
                recyclerViewBaiHocHot.setAdapter(baiHocAdapter);
            }

            @Override
            public void onFailure(Call<List<BaiHoc>> call, Throwable t) {

            }
        });
    }

    private void anhXa() {
        recyclerViewBaiHocHot = view.findViewById(R.id.rv_baihoc_hot);
        textViewXemThem = view.findViewById(R.id.tv_xemthem_baihoc_hot);
    }
}
