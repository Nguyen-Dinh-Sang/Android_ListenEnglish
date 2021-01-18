package com.example.listenenglish.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listenenglish.R;
import com.example.listenenglish.model.File;

import java.util.ArrayList;

public class PlayAdapter extends RecyclerView.Adapter<PlayAdapter.ViewHolder>{
    Context         context;
    ArrayList<File> fileArrayList;

    public PlayAdapter(Context context, ArrayList<File> fileArrayList) {
        this.context = context;
        this.fileArrayList = fileArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_play_file, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        File file = fileArrayList.get(position);

        holder.textViewTen.setText(file.getTenFile());
        holder.textViewNoiDung.setText(file.getNoiDung());
        holder.textViewIndex.setText(position + 1 + "");
    }

    @Override
    public int getItemCount() {
        return fileArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewIndex, textViewTen, textViewNoiDung;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTen     = itemView.findViewById(R.id.tv_play_tenfile);
            textViewIndex   = itemView.findViewById(R.id.tv_play_index);
            textViewNoiDung = itemView.findViewById(R.id.tv_play_noidung);
        }
    }
}
