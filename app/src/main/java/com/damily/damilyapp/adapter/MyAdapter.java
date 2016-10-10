package com.damily.damilyapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Dandan.Cao on 2016/9/21.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    public List<String> mDataset;
    public MyAdapter(List<String> data) {
        this.mDataset=data;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(parent.getContext(),android.R.layout.simple_list_item_1,null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.textView.setText(mDataset.get(position));
    }
    private void removeData(int position) {
        mDataset.remove(position);
        notifyItemRemoved(position);

              }


    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public  TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView;

        }
    }


}
