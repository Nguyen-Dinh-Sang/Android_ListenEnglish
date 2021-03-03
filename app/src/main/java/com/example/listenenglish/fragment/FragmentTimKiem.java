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
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listenenglish.R;
import com.example.listenenglish.adapter.SearchAdapter;
import com.example.listenenglish.model.File;
import com.example.listenenglish.service.APIService;
import com.example.listenenglish.service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentTimKiem extends Fragment {
    View view;
    Toolbar toolbarSearch;
    RecyclerView recyclerViewSearchResults;
    TextView textViewNoData;
    SearchAdapter searchAdapter;

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
                searchKeyWord(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }

    private void searchKeyWord(String keyWord) {
        DataService dataService = APIService.getService();
        Call<List<File>> callBack = dataService.getSearch(keyWord);
        callBack.enqueue(new Callback<List<File>>() {
            @Override
            public void onResponse(Call<List<File>> call, Response<List<File>> response) {
                ArrayList<File> arrayListFile = (ArrayList<File>) response.body();
                if (arrayListFile.size() > 0) {
                    searchAdapter = new SearchAdapter(getActivity(), arrayListFile);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                    recyclerViewSearchResults.setLayoutManager(linearLayoutManager);
                    recyclerViewSearchResults.setAdapter(searchAdapter);
                    textViewNoData.setVisibility(View.GONE);
                    recyclerViewSearchResults.setVisibility(View.VISIBLE);
                } else {
                    textViewNoData.setVisibility(View.VISIBLE);
                    recyclerViewSearchResults.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<List<File>> call, Throwable t) {

            }
        });
    }
}
