package com.bis.accessibility.utils.ui;

import android.view.Gravity;
import android.widget.Toast;

import com.bis.accessibility.app.App;

import androidx.annotation.StringRes;


/**
 * Create by cmh on 2019/8/6
 * name : 江海锋
 * Class Action : show Toast
 */

public class MyToast {
    private static String lastContent;
    private static long lastTimeStamp = 0;

    public static void show(String message) {
        if (message == null || message.equals("")) return;
        if (!message.equals(lastContent)) {
            //不是的话,直接显示
            showToast(message);
        } else {
            //相同的内容,间隔3s后弹出
            long timeD = System.currentTimeMillis() - lastTimeStamp;
            if (timeD > 3000) {
                showToast(message);
            }
        }
    }

    public static void show(@StringRes int strResId) {
        show(ResUtils.getString(strResId));
    }

    private static void showToast(String message) {
        Toast.makeText(App.getContext(), message, Toast.LENGTH_LONG).show();
        lastContent = message;
        lastTimeStamp = System.currentTimeMillis();
    }

    private static void showToastMiddle(String message) {
        Toast toast = Toast.makeText(App.getContext(), message, Toast.LENGTH_LONG);
        lastContent = message;
        lastTimeStamp = System.currentTimeMillis();
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public static void showMiddle(String message) {
        if (message == null || message.equals("")) return;
        if (!message.equals(lastContent)) {
            //不是的话,直接显示
            showToastMiddle(message);
        } else {
            //相同的内容,间隔3s后弹出
            long timeD = System.currentTimeMillis() - lastTimeStamp;
            if (timeD > 3000) {
                showToastMiddle(message);
            }
        }
    }


    public static void showMiddle(@StringRes int strResId) {
        show(ResUtils.getString(strResId));
    }
}
