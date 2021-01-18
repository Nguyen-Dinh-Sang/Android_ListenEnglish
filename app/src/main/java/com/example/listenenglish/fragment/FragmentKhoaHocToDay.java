package com.example.listenenglish.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.listenenglish.R;
import com.example.listenenglish.activity.DanhSachFileActivity;
import com.example.listenenglish.activity.DanhSachKhoaHocActivity;
import com.example.listenenglish.adapter.KhoaHocToDayAdapter;
import com.example.listenenglish.model.KhoaHoc;
import com.example.listenenglish.service.APIService;
import com.example.listenenglish.service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentKhoaHocToDay extends Fragment {
    View view;
    ListView listViewKhoaHocToDay;
    TextView textViewTitle, textViewXemThem;
    KhoaHocToDayAdapter khoaHocToDayAdapter;
    ArrayList<KhoaHoc> khoaHocToDays;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_khoahoctoday,container,false);
        anhXa();
        getData();
        initEvent();
        return view;
    }

    private void initEvent() {
        textViewXemThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DanhSachKhoaHocActivity.class);
                startActivity(intent);
            }
        });
    }

    private void anhXa() {
        listViewKhoaHocToDay = view.findViewById(R.id.lv_khoahoc_today);
        textViewTitle = view.findViewById(R.id.tv_title_banner);
        textViewXemThem = view.findViewById(R.id.itv_xemthem);
    }

    private void getData() {
        DataService dataService = APIService.getService();
        Call<List<KhoaHoc>> callBack = dataService.getKhoaHocToDay();
        callBack.enqueue(new Callback<List<KhoaHoc>>() {
            @Override
            public void onResponse(Call<List<KhoaHoc>> call, Response<List<KhoaHoc>> response) {
                khoaHocToDays = (ArrayList<KhoaHoc>) response.body();
                Log.d("Sang OK", "KhoaHoc OK " + khoaHocToDays.size());
                khoaHocToDayAdapter = new KhoaHocToDayAdapter(getActivity(),android.R.layout.simple_list_item_1,khoaHocToDays);
                listViewKhoaHocToDay.setAdapter(khoaHocToDayAdapter);
                setListViewHeightBasedOnChildren(listViewKhoaHocToDay);
                listViewKhoaHocToDay.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(getActivity(), DanhSachFileActivity.class);
                        intent.putExtra("khoahoctoday", khoaHocToDays.get(position));
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onFailure(Call<List<KhoaHoc>> call, Throwable t) {

            }
        });
    }

    public void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = listView.getPaddingTop() + listView.getPaddingBottom();
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.AT_MOST);
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);

            if(listItem != null){
                // This next line is needed before you call measure or else you won't get measured height at all. The listitem needs to be drawn first to know the height.
                listItem.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
                listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
                totalHeight += listItem.getMeasuredHeight();

            }
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }
}
