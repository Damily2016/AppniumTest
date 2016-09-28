package com.damily.damilyapp.ui;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.damily.damilyapp.MainActivity;
import com.damily.damilyapp.R;
import com.damily.damilyapp.angine.UpdateInfoService;
import com.damily.damilyapp.entity.UpdateInfo;

public class SplashActivity extends Activity {
	private TextView tv_splash_version;
	private LinearLayout ll_splash_main;
	private String versiontext;
	private String TAG="SplashActivity";
	private UpdateInfo info;
	private Handler handler=new Handler(){
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
		if (isNeedUpdate(versiontext)) {
			Log.i(TAG,"弹出升级对话框");
			showUpdateDialog();
		}
		}		
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//取消标题栏
//		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.splash);
		tv_splash_version=(TextView) findViewById(R.id.tv_splash_version);
		versiontext=getVersion();
		new Thread(){
			@Override
			public void run() {
			try {
				sleep(1000);
			handler.sendEmptyMessage(0);
			} catch (Exception e) {
			
				e.printStackTrace();
			}
			
			}
		}.start();
/*		if (isNeedUpdate(versiontext)) {
			Log.i(TAG,"弹出升级对话框");
			showUpdateDialog();
		}*/
		tv_splash_version.setText(versiontext);//版本号设置
		
		ll_splash_main=(LinearLayout) findViewById(R.id.ll_splash_main);
		AlphaAnimation a=new AlphaAnimation(0.0f, 1.0f);
		a.setDuration(2000);
		ll_splash_main.startAnimation(a);

		//完成窗体的全屏显示
	//	getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
	
	}
	private void showUpdateDialog() {
	Builder builder=new Builder(this);
	builder.setIcon(R.drawable.icon5);
	builder.setTitle("升级对话框");
	builder.setMessage(info.getDescription());
	builder.setCancelable(false);
	builder.setPositiveButton("确定",new OnClickListener() {
		public void onClick(DialogInterface dialog, int which) {
			Log.i(TAG,"下载APK的文件"+info.getApkurl());
		}
	} );
	builder.setNegativeButton("取消", new OnClickListener() {
		
		@Override
		public void onClick(DialogInterface dialog, int which) {
			Log.i(TAG,"用户取消，进入主界面");
			loadMainUI();
			
		}
	});
	builder.show();
	}
private boolean isNeedUpdate(String versiontext) {
	UpdateInfoService service=new UpdateInfoService(this);
	try {
		UpdateInfo info=service.getUpdateInfo(R.string.updateurl);
		String version=info.getVersion();
		if (versiontext.equals(version)) {
			Log.i(TAG,"版本相同无需升级，进入主界面");
			loadMainUI();
			return false;
		}else {
			Log.i(TAG,"版本升级");
			return true;
		}
	} catch (Exception e) {
		
		e.printStackTrace();
		Log.i(TAG,"获取更新信息异常，进入主界面");
		loadMainUI();
		return false;
	}
	
		
	}


private String getVersion(){
	 try {
		 PackageManager manager=getPackageManager();
		 PackageInfo info=manager.getPackageInfo(getPackageName(), 0);
		 return info.versionName;
	 } catch (NameNotFoundException e) {
		 
		e.printStackTrace();
		return "@strings/version";
	}
	
}

private void loadMainUI(){
	Intent intent=new Intent(this,MainActivity.class);
	startActivity(intent);
	finish();
}
}
