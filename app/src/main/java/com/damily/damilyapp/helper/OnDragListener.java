package com.damily.damilyapp.helper;

import com.damily.damilyapp.adapter.MyAdapter;

/**
 * Created by Dandan.Cao on 2016/9/22.
 */
public interface OnDragListener {
    public void onStartDrag(MyAdapter.ViewHolder holder);
    public void onStartSwipe(MyAdapter.ViewHolder holder);
}
