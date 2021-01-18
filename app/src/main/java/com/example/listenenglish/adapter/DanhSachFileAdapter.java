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

import com.example.listenenglish.R;
import com.example.listenenglish.activity.PlayActivity;
import com.example.listenenglish.model.File;
import com.example.listenenglish.service.APIService;
import com.example.listenenglish.service.DataService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhSachFileAdapter extends RecyclerView.Adapter<DanhSachFileAdapter.ViewHolder>{
    Context context;
    ArrayList<File> fileArrayList;

    public DanhSachFileAdapter(Context context, ArrayList<File> fileArrayList) {
        this.context = context;
        this.fileArrayList = fileArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_danhsach_file, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        File file = fileArrayList.get(position);

        holder.textViewTenFile.setText(file.getTenFile());
        holder.textViewMoTa.setText(file.getMoTa());
        holder.textViewIndex.setText((position + 1) + "");
    }

    @Override
    public int getItemCount() {
        return fileArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewIndex, textViewTenFile, textViewMoTa;
        ImageView imageViewThich;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewIndex = itemView.findViewById(R.id.tv_danhsach_index);
            textViewTenFile = itemView.findViewById(R.id.tv_ten_file);
            textViewMoTa = itemView.findViewById(R.id.tv_mota_file);
            imageViewThich = itemView.findViewById(R.id.iv_thich);

            imageViewThich.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imageViewThich.setImageResource(R.drawable.ic_like);
                    DataService dataService = APIService.getService();
                    Call<String> callBack = dataService.updateLike("1", fileArrayList.get(getPosition()).getIdFile());
                    callBack.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            String ketQua = response.body();
                            Log.d("Sang OK", "File_YeuThich_Like OK " + ketQua);
                            if (ketQua.equals("Success")) {
                                Toast.makeText(context, "Đã thích", Toast.LENGTH_SHORT).show();
                                imageViewThich.setEnabled(false);
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
                    intent.putExtra("file", fileArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
