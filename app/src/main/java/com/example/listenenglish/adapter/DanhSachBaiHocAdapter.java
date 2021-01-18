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

public class DanhSachBaiHocAdapter extends  RecyclerView.Adapter<DanhSachBaiHocAdapter.ViewHolder>{
    Context context;
    ArrayList<BaiHoc> baiHocArrayList;

    public DanhSachBaiHocAdapter(Context context, ArrayList<BaiHoc> baiHocArrayList) {
        this.context = context;
        this.baiHocArrayList = baiHocArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_danhsach_baihoc, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BaiHoc baiHoc = baiHocArrayList.get(position);
        Glide.with(context).load(baiHoc.getIConBaiHoc()).into(holder.imageViewHinhAnh);
        holder.textViewTenBaiHoc.setText(baiHoc.getTenKhoaHoc());
    }

    @Override
    public int getItemCount() {
        return baiHocArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewHinhAnh;
        TextView textViewTenBaiHoc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewHinhAnh = itemView.findViewById(R.id.iv_item_baihoc);
            textViewTenBaiHoc = itemView.findViewById(R.id.tv_ten_baihoc);

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
