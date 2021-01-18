package com.example.listenenglish.adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ViewPagerMainAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> arrayListFragments = new ArrayList<>();
    private ArrayList<String> arrayListTitle = new ArrayList<>();

    public ViewPagerMainAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return arrayListFragments.get(position);
    }

    @Override
    public int getCount() {
        return arrayListFragments.size();
    }

    public void addFragment(Fragment fragment, String title) {
        arrayListFragments.add(fragment);
        arrayListTitle.add(title);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return arrayListTitle.get(position);
    }
}
