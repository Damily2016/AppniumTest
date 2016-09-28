package com.damily.damilyapp.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.damily.damilyapp.R;
import com.damily.damilyapp.adapter.MypageAdapter;

import java.util.ArrayList;
import java.util.List;
public class HomeFragment extends Fragment {
	private TabLayout tb_layout;
	private ViewPager viewPager;
	private View rootview;
	private static String title;
	private String[] titles;
	private List<Fragment> fragments = new ArrayList<>();
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootview = inflater.inflate(R.layout.content_main, null);
		titles = getResources().getStringArray(R.array.tab_title);

		Fragment firstTabFragment=new FirstTabFragment();
		Fragment secondFragment=new SecondTabFragment();
		Fragment thirdFragment=new ThirdTabFragment();
		Fragment fourthFragment=new FourthTabFragment();
		fragments.add(thirdFragment);//展示的第一页fragment
		fragments.add(secondFragment);
		fragments.add(firstTabFragment);//展示的第三页fragment
		fragments.add(fourthFragment);
		tb_layout = (TabLayout)rootview. findViewById(R.id.tab_layout);
		viewPager = (ViewPager)rootview. findViewById(R.id.viewpager);
		tb_layout.setTabMode(TabLayout.MODE_SCROLLABLE);
		viewPager.setOffscreenPageLimit(2);
		MypageAdapter mpageAdapter = new MypageAdapter(getChildFragmentManager(), titles, fragments);
		viewPager.setAdapter(mpageAdapter);
		tb_layout.setupWithViewPager(viewPager);
		return rootview;

	}
}
