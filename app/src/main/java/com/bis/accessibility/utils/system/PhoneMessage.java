package com.bis.accessibility.utils.system;


import android.content.Context;
import android.os.Build;

/**
 * 手机相关信息获取
 */
public class PhoneMessage {

    //获取设备的屏幕宽度
    public static int getDeviceWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    //获取设备的屏幕高度
    public static int getDeviceHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    //获取厂商名
    public static String getDeviceManufacturer() {

        return Build.MANUFACTURER;
    }

    //获取手机品牌
    public static String getDeviceBrand() {

        return Build.BRAND;
    }

    //获取手机型号
    public static String getDeviceModel() {
        return Build.MODEL;
    }

    //获取手机Android系统SDK
    public static int getDeviceSDK() {
        return Build.VERSION.SDK_INT;
    }

    //获取手机Android版本
    public static String getDeviceAndroidVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String getPhoneMessage(Context context)
    {

        String phoneMessage = "屏幕宽度:" + getDeviceWidth(context) + "\n" + "屏幕高度:" + getDeviceHeight(context) + "\n" + "手机厂商名:" + getDeviceManufacturer()

                + "\n" +  "手机品牌:" + getDeviceBrand() + "\n" + "手机型号:" + getDeviceModel() + "\n" + "Android系统SDK:" + getDeviceSDK()

                + "\n" + "手机Android版本:" + getDeviceAndroidVersion() ;

        return phoneMessage;

    }
}
