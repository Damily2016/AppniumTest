package com.damily.damilyapp.entity;

import android.graphics.drawable.Drawable;

/**
 * Created by Dandan.Cao on 2016/9/13.
 */
public class AppInfo {
    private Drawable appIcon;
    private String appName;
    private String packName;
    private boolean isSystemApp;

    public Drawable getAppIcon() {
        return appIcon;
    }

    public void setAppIcon(Drawable appIcon) {
        this.appIcon = appIcon;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getPackName() {
        return packName;
    }

    public void setPackName(String packName) {
        this.packName = packName;
    }

    public boolean isSystemApp() {
        return isSystemApp;
    }

    public void setSystemApp(boolean systemApp) {
        isSystemApp = systemApp;
    }

    @Override
    public String toString() {
        return "AppInfo{" +
                "appIcon=" + appIcon +
                ", appName='" + appName + '\'' +
                ", packName='" + packName + '\'' +
                ", isSystemApp=" + isSystemApp +
                '}';
    }
}
