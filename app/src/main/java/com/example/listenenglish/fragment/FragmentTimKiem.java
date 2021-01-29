package com.example.listenenglish.fragment;

import android.app.AppComponentFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listenenglish.R;

public class FragmentTimKiem extends Fragment {
    View view;
    Toolbar toolbarSearch;
    RecyclerView recyclerViewSearchResults;
    TextView textViewNoData;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_timkiem, container, false);
        initView();
        return view;
    }

    private void initView() {
        toolbarSearch = view.findViewById(R.id.tb_search);
        recyclerViewSearchResults = view.findViewById(R.id.rclv_search_results);
        textViewNoData = view.findViewById(R.id.tv_no_data);

        //bản chất fragment không phải là activity nên không thể hiển thị được toolbar
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbarSearch);
        toolbarSearch.setTitle("");
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem menuItem = menu.findItem(R.id.item_menu_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d("Sang OK: SearchView:", query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }
}
