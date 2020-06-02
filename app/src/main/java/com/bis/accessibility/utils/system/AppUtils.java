package com.bis.accessibility.utils.system;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

import java.util.Objects;

/**
 * 获取app相关信息
 */
public class AppUtils {

    public static final String PACKAGE_FILE_PROVIDER = "com.bis.insigma.oa.fileprovider";

    /**
     * 获取应用程序名称
     */
    private static synchronized String getAppName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    context.getPackageName(), 0);
            int labelRes = packageInfo.applicationInfo.labelRes;
            return context.getResources().getString(labelRes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * [获取应用程序版本名称信息]
     *
     * @param context
     * @return 当前应用的版本名称
     */
    private static synchronized String getVersionName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    context.getPackageName(), 0);
            return packageInfo.versionName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * [获取当前WIFI MAC地址]
     *
     * @param mContext
     * @return
     */
    public static String getCurrentWifiInfo(Context mContext) {
        @SuppressLint("WifiManagerPotentialLeak") WifiManager wifi = (WifiManager) mContext.getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = Objects.requireNonNull(wifi).getConnectionInfo();
        return info.getBSSID();
    }


    /**
     * [获取应用程序版本号]
     *
     * @param context
     * @return 当前应用的版本号
     */
    private static synchronized int getVersionCode(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    context.getPackageName(), 0);
            return packageInfo.versionCode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    //获取当前的activity的完整路径
    public static String getRunningActivityName(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        String runningActivity = null;
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            runningActivity = activityManager.getRunningTasks(1).get(0).topActivity.getClassName();
        }
        return runningActivity;
    }


    //用于错误日志存进手机中使用
    public static String getAppMessage(Context context) {
        String message = "\n App名称：" + getAppName(context) + "\n 版本名称:" + getVersionName(context) + "\n 版本号:" + getVersionCode(context) + "\n 类名：" + getRunningActivityName(context);

        return message;
    }
}