package com.damily.damilyapp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Dandan.Cao on 2016/9/12.
 */
public class MypageAdapter extends FragmentPagerAdapter {
    private String[] names;
    private List<Fragment> fragments;

    public MypageAdapter(FragmentManager fm, String[] names, List<Fragment> fragments) {
        super(fm);
        this.names = names;
        this.fragments = fragments;

    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return names[position];
    }
}
