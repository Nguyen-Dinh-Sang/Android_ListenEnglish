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
import com.example.listenenglish.model.BaiHoc;

import java.util.ArrayList;

public class BaiHocAdapter extends RecyclerView.Adapter<BaiHocAdapter.ViewHolder>{
    Context context;
    ArrayList<BaiHoc> baiHocArrayList;

    public BaiHocAdapter(Context context, ArrayList<BaiHoc> baiHocArrayList) {
        this.context = context;
        this.baiHocArrayList = baiHocArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_baihoc_hot, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BaiHoc baiHoc = baiHocArrayList.get(position);
        holder.textViewTenBaiHoc.setText(baiHoc.getTenKhoaHoc());
        holder.textViewNoiDungBaiHoc.setText(baiHoc.getMoTa());
        Glide.with(context).load(baiHoc.getIConBaiHoc()).into(holder.imageViewHinhBaiHoc);
    }

    @Override
    public int getItemCount() {
        return baiHocArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewHinhBaiHoc;
        TextView textViewTenBaiHoc, textViewNoiDungBaiHoc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewHinhBaiHoc = itemView.findViewById(R.id.iv_baihoc_hot);
            textViewNoiDungBaiHoc = itemView.findViewById(R.id.tv_mota_baihoc_hot);
            textViewTenBaiHoc = itemView.findViewById(R.id.tv_ten_baihoc_hot);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DanhSachFileActivity.class);
                    intent.putExtra("baihoc", baiHocArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
