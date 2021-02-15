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
import com.example.listenenglish.service.APIRetrofitClient;
import com.example.listenenglish.service.APIService;
import com.example.listenenglish.service.DataService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder>{
    Context context;
    ArrayList<File> arrayListFile;

    public SearchAdapter(Context context, ArrayList<File> arrayListFile) {
        this.context = context;
        this.arrayListFile = arrayListFile;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_search, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        File file = arrayListFile.get(position);
        holder.textViewFileName.setText(file.getTenFile());
        holder.textViewDescription.setText(file.getMoTa());
        Glide.with(context).load(file.getIconFile()).into(holder.imageViewFile);
    }

    @Override
    public int getItemCount() {
        return arrayListFile.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewFileName, textViewDescription;
        ImageView imageViewFile, imageViewLike;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewFileName = itemView.findViewById(R.id.tv_search_ten_fine);
            textViewDescription = itemView.findViewById(R.id.tv_search_mota_fine);
            imageViewFile = itemView.findViewById(R.id.iv_search_file);
            imageViewLike = itemView.findViewById(R.id.iv_search_luotthich);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, PlayActivity.class);
                    intent.putExtra("file", arrayListFile.get(getPosition()));
                    context.startActivity(intent);
                }
            });
            imageViewLike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imageViewLike.setImageResource(R.drawable.ic_like);
                    DataService dataService = APIService.getService();
                    Call<String> callBack = dataService.updateLike("1", arrayListFile.get(getPosition()).getIdFile());
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
        }
    }
}
