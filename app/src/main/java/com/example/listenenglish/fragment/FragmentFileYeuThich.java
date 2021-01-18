package com.example.listenenglish.fragment;

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
import com.example.listenenglish.adapter.FileHotAdapter;
import com.example.listenenglish.model.File;
import com.example.listenenglish.service.APIService;
import com.example.listenenglish.service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentFileYeuThich extends Fragment {
    View view;
    RecyclerView fileHotRecyclerView;
    FileHotAdapter fileHotAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_file_yeuthich, container, false);
        anhXa();
        getData();
        return view;
    }

    private void getData() {
        DataService dataService = APIService.getService();
        Call<List<File>> callBack = dataService.getFileYeuThich();
        callBack.enqueue(new Callback<List<File>>() {
            @Override
            public void onResponse(Call<List<File>> call, Response<List<File>> response) {
                ArrayList<File> fileArrayList = (ArrayList<File>) response.body();
                Log.d("Sang OK", "File_YeuThich OK " + fileArrayList.size());

                fileHotAdapter = new FileHotAdapter(getActivity(), fileArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                fileHotRecyclerView.setLayoutManager(linearLayoutManager);
                fileHotRecyclerView.setAdapter(fileHotAdapter);
            }

            @Override
            public void onFailure(Call<List<File>> call, Throwable t) {

            }
        });
    }

    private void anhXa() {
        fileHotRecyclerView = view.findViewById(R.id.rv_file_yeuthich);
    }
}
