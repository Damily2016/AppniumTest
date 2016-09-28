package com.damily.damilyapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.damily.damilyapp.R;

/**
 * Created by Dandan.Cao on 2016/9/13.
 */
public class SecondTabFragment extends Fragment{
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      view=  inflater.inflate(R.layout.fragment_tab,null);
        return view;
    }
}
