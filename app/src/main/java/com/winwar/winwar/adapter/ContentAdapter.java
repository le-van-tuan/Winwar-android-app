package com.winwar.winwar.adapter;


import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ContentAdapter extends FragmentPagerAdapter {

    private List<Fragment> pageContent = new ArrayList<>();
    private List<String> pageTitle = new ArrayList<>();

    public ContentAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragmentPage(Fragment fragment, String title){
        pageContent.add(fragment);
        pageTitle.add(title);
    }

    @Override
    public Fragment getItem(int position) {
        return pageContent.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return pageTitle.get(position);
    }

    @Override
    public int getCount() {
        return pageContent.size();
    }
}
