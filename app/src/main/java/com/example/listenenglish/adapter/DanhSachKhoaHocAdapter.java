package com.example.listenenglish.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.listenenglish.R;
import com.example.listenenglish.activity.DanhSachFileActivity;
import com.example.listenenglish.model.KhoaHoc;

import java.util.ArrayList;

public class DanhSachKhoaHocAdapter extends RecyclerView.Adapter<DanhSachKhoaHocAdapter.ViewHolder> {
    Context context;
    ArrayList<KhoaHoc> khoaHocArrayList;

    public DanhSachKhoaHocAdapter(Context context, ArrayList<KhoaHoc> khoaHocArrayList) {
        this.context = context;
        this.khoaHocArrayList = khoaHocArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_danhsach_khoahoc, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        KhoaHoc khoaHoc = khoaHocArrayList.get(position);
        Glide.with(context).load(khoaHoc.getIconKhoaHoc()).into(holder.imageView);
        holder.textViewMoTaKhoaHoc.setText(khoaHoc.getMoTa());
        holder.textViewTenKhoaHoc.setText(khoaHoc.getTenKhoaHoc());
    }

    @Override
    public int getItemCount() {
        return khoaHocArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewTenKhoaHoc, textViewMoTaKhoaHoc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_danhsach_khoahoc);
            textViewTenKhoaHoc = itemView.findViewById(R.id.tv_ten_khoahoc);
            textViewMoTaKhoaHoc = itemView.findViewById(R.id.tv_mota_khoahoc);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DanhSachFileActivity.class);
                    intent.putExtra("khoahoctoday", khoaHocArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
