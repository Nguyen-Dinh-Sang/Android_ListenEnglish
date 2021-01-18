package com.example.listenenglish.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.listenenglish.R;
import com.example.listenenglish.activity.PlayActivity;
import com.example.listenenglish.model.File;
import com.example.listenenglish.service.APIService;
import com.example.listenenglish.service.DataService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FileHotAdapter extends RecyclerView.Adapter<FileHotAdapter.ViewHolder>{
    Context context;
    ArrayList<File> fileHotArrayList;

    public FileHotAdapter(Context context, ArrayList<File> fileHotArrayList) {
        this.context = context;
        this.fileHotArrayList = fileHotArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_file_hot, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        File file = fileHotArrayList.get(position);
        holder.textViewTenFile.setText(file.getTenFile());
        holder.textViewMoTaFile.setText(file.getMoTa());
        Glide.with(context).load(file.getIconFile()).into(holder.imageViewHinh);
    }

    @Override
    public int getItemCount() {
        return fileHotArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTenFile, textViewMoTaFile;
        ImageView imageViewHinh, imageViewLike;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewMoTaFile = itemView.findViewById(R.id.tv_mota_file_yeuthich);
            textViewTenFile = itemView.findViewById(R.id.tv_ten_file_yeuthich);
            imageViewHinh = itemView.findViewById(R.id.iv_file_yeuthich);
            imageViewLike = itemView.findViewById(R.id.iv_luotthich);

            imageViewLike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imageViewLike.setImageResource(R.drawable.ic_like);
                    DataService dataService = APIService.getService();
                    Call<String> callBack = dataService.updateLike("1", fileHotArrayList.get(getPosition()).getIdFile());
                    callBack.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            String ketQua = response.body();
                            Log.d("Sang OK", "File_YeuThich_Like OK " + ketQua);
                            if (ketQua.equals("Success")) {
                                Toast.makeText(context, "Đã thích", Toast.LENGTH_SHORT).show();
                                imageViewLike.setEnabled(false);
                            } else {
                                Toast.makeText(context, "Lỗi !", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {

                        }
                    });
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, PlayActivity.class);
                    intent.putExtra("file", fileHotArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
