package com.example.listenenglish.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listenenglish.R;
import com.example.listenenglish.activity.PlayActivity;
import com.example.listenenglish.adapter.PlayAdapter;

public class FragmentPlayDanhSachFile extends Fragment {
    View            view;
    RecyclerView    recyclerView;
    PlayAdapter     adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_play_danhsach_file, container, false);
        recyclerView = view.findViewById(R.id.rv_play);

        if (PlayActivity.fileArrayList.size() > 0) {
            adapter = new PlayAdapter(getActivity(), PlayActivity.fileArrayList);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(adapter);
        }

        return view;
    }
}
