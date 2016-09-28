package com.damily.damilyapp.angine;

import android.content.Context;

import com.damily.damilyapp.entity.UpdateInfo;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class UpdateInfoService {
	private Context context;
	

	public UpdateInfo getUpdateInfo(int urlid)throws Exception{
		String path=context.getResources().getString(urlid);
		URL url=new URL(path);
		HttpURLConnection conn=	(HttpURLConnection) url.openConnection();
		conn.setConnectTimeout(5000);
		conn.setRequestMethod("GET");
		 InputStream  is=conn.getInputStream();
		 
		return UpdateInfoParser.getUpdateInfo(is);
		
	}


	public UpdateInfoService(Context context) {
		
		this.context = context;
	}
}
