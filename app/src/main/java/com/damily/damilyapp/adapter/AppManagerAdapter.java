package com.damily.damilyapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.damily.damilyapp.R;
import com.damily.damilyapp.entity.AppInfo;

import java.util.List;

/**
 * Created by Dandan.Cao on 2016/9/13.
 */
public class AppManagerAdapter extends RecyclerView.Adapter<AppManagerAdapter.ViewHolder> {
    private static ImageView iv;
    private static TextView tv;
    private List<AppInfo> appInfos;
    private static final String TAG = "AppManagerAdapter";

    public AppManagerAdapter(List<AppInfo> appInfos) {
        this.appInfos = appInfos;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.app_manager_item, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        AppInfo info = appInfos.get(position);
        holder.iv_icon.setImageDrawable(info.getAppIcon());
        holder.tv_app_name.setText(info.getAppName());
    }

    @Override
    public int getItemCount() {
        return appInfos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_icon;
        private TextView tv_app_name;

        public ViewHolder(View view) {
            super(view);
            iv_icon = (ImageView) view.findViewById(R.id.iv_icon);
            tv_app_name = (TextView) view.findViewById(R.id.tv_app_name);

        }
    }
}
