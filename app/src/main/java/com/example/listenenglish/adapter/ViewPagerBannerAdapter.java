package com.example.listenenglish.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.listenenglish.R;
import com.example.listenenglish.activity.DanhSachFileActivity;
import com.example.listenenglish.model.QuangCao;

import java.util.ArrayList;

public class ViewPagerBannerAdapter extends PagerAdapter {
    Context context;
    ArrayList<QuangCao> arrayListQuangCao;

    public ViewPagerBannerAdapter(Context context, ArrayList<QuangCao> arrayListQuangCao) {
        this.context = context;
        this.arrayListQuangCao = arrayListQuangCao;
    }

    @Override
    public int getCount() {
        return arrayListQuangCao.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull final ViewGroup container, final int position) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_banner,null);
        ImageView imageViewBackgroundBanner = view.findViewById(R.id.iv_backgroundbanner);
        ImageView imageViewBanner = view.findViewById(R.id.iv_banner);
        TextView textViewTitle = view.findViewById(R.id.tv_title_banner);
        TextView textViewNoiDung = view.findViewById(R.id.tv_noidung_banner);

        Glide.with(context).load(arrayListQuangCao.get(position).getIconQuangCao()).into(imageViewBackgroundBanner);
        Glide.with(context).load(arrayListQuangCao.get(position).getIconFile()).into(imageViewBanner);
        textViewTitle.setText(arrayListQuangCao.get(position).getTenFile());
        textViewNoiDung.setText(arrayListQuangCao.get(position).getNoiDung());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DanhSachFileActivity.class);
                intent.putExtra("banner", arrayListQuangCao.get(position));
                context.startActivity(intent);
            }
        });

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
