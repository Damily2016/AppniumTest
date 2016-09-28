package com.damily.damilyapp.angine;

import android.util.Xml;

import com.damily.damilyapp.entity.UpdateInfo;

import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;
public class UpdateInfoParser {
	public static UpdateInfo getUpdateInfo(InputStream is) throws Exception{
		 XmlPullParser parser=	Xml.newPullParser();
		 parser.setInput(is,"utf-8");
		int type= parser.getEventType();
		UpdateInfo info=new UpdateInfo();
		while (type!=XmlPullParser.END_DOCUMENT) {
			switch (type) {
			case XmlPullParser.START_TAG:
				if ("version".equals(parser.getName())) {
					String version=parser.nextText();
					info.setVersion(version);
				}else if ("description".equals(parser.getName())) {
					String description=parser.nextText();
					info.setDescription(description);
				}else if ("apkurl".equals(parser.getName())) {
					String apkurl=parser.nextText();
					info.setApkurl(apkurl);
				}
				break;

			}
			
		type=parser.next();
			
		}
		return info;
		
	
		
		
	}
	
	
}
