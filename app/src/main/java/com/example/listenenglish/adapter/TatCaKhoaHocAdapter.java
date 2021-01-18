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
import com.example.listenenglish.activity.DanhSachBaiHocActivity;
import com.example.listenenglish.activity.DanhSachFileActivity;
import com.example.listenenglish.model.KhoaHoc;

import java.util.ArrayList;

public class TatCaKhoaHocAdapter extends RecyclerView.Adapter<TatCaKhoaHocAdapter.ViewHolder>{
    Context context;
    ArrayList<KhoaHoc> khoaHocArrayList;

    public TatCaKhoaHocAdapter(Context context, ArrayList<KhoaHoc> khoaHocArrayList) {
        this.context = context;
        this.khoaHocArrayList = khoaHocArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_tatca_khoahoc, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        KhoaHoc khoaHoc = khoaHocArrayList.get(position);

        Glide.with(context).load(khoaHoc.getIconKhoaHoc()).into(holder.imageViewKhoaHoc);
        holder.textView.setText(khoaHoc.getTenKhoaHoc());
    }

    @Override
    public int getItemCount() {
        return khoaHocArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewKhoaHoc;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewKhoaHoc = itemView.findViewById(R.id.iv_tatca_khoahoc);
            textView = itemView.findViewById(R.id.tv_tieude);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DanhSachBaiHocActivity.class);
                    intent.putExtra("khoahoc", khoaHocArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
