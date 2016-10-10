package com.damily.damilyapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.damily.damilyapp.R;
import com.damily.damilyapp.adapter.AppManagerAdapter;
import com.damily.damilyapp.angine.AppInfoProvider;
import com.damily.damilyapp.entity.AppInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dandan.Cao on 2016/9/26.
 */
public class FourthTabFragment extends Fragment {
    private View view;
    private LinearLayout ll_app_loading;
    private RecyclerView recyclerView;
    private Context context;
    private AppManagerAdapter adapter;
    private List<AppInfo> userAppinfos = new ArrayList<>();//初始化数据
    List<AppInfo> appinfos;
    private AppInfoProvider provider;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            appinfos = (List<AppInfo>) msg.obj;
            ll_app_loading.setVisibility(View.INVISIBLE);
            userAppinfos.addAll(appinfos);//
            adapter.notifyDataSetChanged();
        }
    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_tab4, null);
        context = getActivity();//初始化context
        ll_app_loading = (LinearLayout) view.findViewById(R.id.ll_app_loading);
        ll_app_loading.setVisibility(View.VISIBLE);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_app_manager);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        // userAppinfos = AppInfoProvider.getUserApps(appInfos);
        adapter = new AppManagerAdapter(userAppinfos);
        recyclerView.setAdapter(adapter);//在子线程之前就设置adapter
        new Thread() {
            @Override
            public void run() {
                super.run();
                provider = new AppInfoProvider(context);
                Message msg = new Message();
                msg.obj = provider.getUserApps();
                handler.sendMessage(msg);
            }
        }.start();
        return view;
    }
}
