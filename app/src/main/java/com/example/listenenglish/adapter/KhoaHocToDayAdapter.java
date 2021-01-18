package com.example.listenenglish.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.listenenglish.R;
import com.example.listenenglish.model.KhoaHoc;

import java.util.List;

public class KhoaHocToDayAdapter extends ArrayAdapter<KhoaHoc> {

    public KhoaHocToDayAdapter(@NonNull Context context, int resource, @NonNull List<KhoaHoc> objects) {
        super(context, resource, objects);
    }

    class ViewHolder {
        TextView textViewTenKhoaHoc;
        ImageView imageViewBackground, imageViewKhoaHoc;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            convertView = layoutInflater.inflate(R.layout.item_khoahoc_today,null);
            viewHolder = new ViewHolder();
            viewHolder.textViewTenKhoaHoc = convertView.findViewById(R.id.tv_ten_khoahoc);
            viewHolder.imageViewBackground = convertView.findViewById(R.id.iv_background_khoahoc_today);
            viewHolder.imageViewKhoaHoc = convertView.findViewById(R.id.iv_khoahoc_today);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        KhoaHoc khoaHocToDay = getItem(position);
        Glide.with(getContext()).load(khoaHocToDay.getIconKhoaHoc()).into(viewHolder.imageViewBackground);
        Glide.with(getContext()).load(khoaHocToDay.getIconKhoaHoc()).into(viewHolder.imageViewKhoaHoc);
        viewHolder.textViewTenKhoaHoc.setText(khoaHocToDay.getTenKhoaHoc());
        return convertView;
    }
}
