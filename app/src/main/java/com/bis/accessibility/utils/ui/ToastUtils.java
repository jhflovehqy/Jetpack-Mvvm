package com.bis.accessibility.utils.ui;

import android.content.Context;

import androidx.annotation.StringRes;

public class ToastUtils {

    public static void show(Context context, String info) {
        MyToast.show(info);
    }

    public static void show(String info) {
        MyToast.show(info);
    }


    public static void show(Context context, @StringRes int info) {
        MyToast.show(info);
    }

    public static void show(@StringRes int info) {
        MyToast.show(info);
    }

    public static void showMiddle(@StringRes int info) {
        MyToast.showMiddle(info);
    }

    public static void showMiddle(String info) {
        MyToast.showMiddle(info);
    }

}
