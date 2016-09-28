package com.damily.damilyapp;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.content.IntentFilter;

import com.squareup.leakcanary.LeakCanary;

import java.util.ArrayList;
import java.util.List;

public class MyApplication extends Application {

//	public TaskInfo taskinfo;
	private List<Activity> activityList=new ArrayList<Activity>();
	private static MyApplication instance;
		public MyApplication() {
		}
		public static MyApplication getInstance(){
			if (null==instance) {
				instance=new MyApplication();
			}
			return instance;
			
		}
	public void addActivity(Activity activity){
		
			activityList.add(activity);
	}
	public void exit(){
		System.exit(0);
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		LeakCanary.install(this);
		IntentFilter filter=new IntentFilter(Intent.ACTION_SCREEN_OFF);
		filter.setPriority(1000);
//		LockScreenReceiver receiver=new LockScreenReceiver();
//		registerReceiver(receiver, filter);
	}

}
