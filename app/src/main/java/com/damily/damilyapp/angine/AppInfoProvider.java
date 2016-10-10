package com.damily.damilyapp.angine;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.util.Log;

import com.damily.damilyapp.entity.AppInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dandan.Cao on 2016/9/13.
 */
public class AppInfoProvider {
    private static final String TAG = "AppInfoProvider";
    private Context context;
    private static PackageManager packageManager;

    public AppInfoProvider(Context context) {
        this.context = context;
        packageManager = context.getPackageManager();
    }

    public static List<AppInfo> getAllApps() {
       /* Drawable appIcon;
         String appName;
         String packName;*/
        List<AppInfo> appInfos = new ArrayList<>();//用来存储获取的应用信息数据
        List<PackageInfo> packageInfos = packageManager.getInstalledPackages(0);

        Log.i(TAG, "packageInfos: " + packageInfos);
        for (PackageInfo info : packageInfos) {
            AppInfo myApp = new AppInfo();
            String packageName = info.packageName;//a
            myApp.setPackName(packageName);
            Log.i(TAG, "packageName: " + packageName);
            ApplicationInfo appinfo = info.applicationInfo;
            Drawable icon = appinfo.loadIcon(packageManager);
            myApp.setAppIcon(icon);//a
            String appname = appinfo.loadLabel(packageManager).toString();
            myApp.setAppName(appname);
if(filterApp(appinfo)){
myApp.setSystemApp(false);

}else{
    myApp.setSystemApp(true);
}



            appInfos.add(myApp);
        }
        return appInfos;
    }

    public static List<AppInfo> getUserApps() {
        List<AppInfo> userAppInfos = new ArrayList<>();
        for (AppInfo appinfo : getAllApps()) {
            if (!appinfo.isSystemApp()) {
                userAppInfos.add(appinfo);
            }
        }
        return userAppInfos;
    }

    // 判断某个应用程序是不是三方的应用程序
    public static boolean filterApp(ApplicationInfo info) {
        if ((info.flags & ApplicationInfo.FLAG_UPDATED_SYSTEM_APP) != 0) {
            return true;
        } else if ((info.flags & ApplicationInfo.FLAG_SYSTEM) == 0) {
            return true;
        }

        return false;
    }


}
