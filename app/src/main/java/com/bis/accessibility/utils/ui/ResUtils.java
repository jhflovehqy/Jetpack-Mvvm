package com.bis.accessibility.utils.ui;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import com.bis.accessibility.app.App;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;

/**
 * Create by cmh on 2019/8/6
 * name : 江海锋
 * Class Action : 工具类
 */
public class ResUtils {
    public static String getString(@StringRes int strResId) {
        return App.getContext().getResources().getString(strResId);
    }

    public static String getString(@StringRes int strResId, Object... obj) {
        return App.getContext().getResources().getString(strResId, obj);
    }

    public static int getColor(@ColorRes int colorResId) {
        return App.getContext().getResources().getColor(colorResId);
    }

    public static Drawable getDrawable(@DrawableRes int drawableResId) {
        return App.getContext().getResources().getDrawable(drawableResId);
    }

    private static float density = Resources.getSystem().getDisplayMetrics().density;

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     *
     * @param dpValue 虚拟像素
     * @return 像素
     */
    public static int dp2px(float dpValue) {
        return (int) (0.5f + dpValue * density);
    }

}
