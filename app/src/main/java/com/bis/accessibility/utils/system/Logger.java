package com.bis.accessibility.utils.system;

import android.content.Context;
import android.util.Log;

import com.bis.accessibility.app.App;
import com.bis.accessibility.utils.system.AppUtils;
import com.bis.accessibility.utils.system.PhoneMessage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 关于操作中的日志信息输出
 *
 * @author 江海锋
 */
public final class Logger {

    private static final boolean isinput = true;// 用于判断是否输出日志 可以控制整个应用的输出 调试模式 true  上线模式 false


    public static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public static void printLine(String tag, boolean isTop) {
        if (isTop) {
            Log.d(tag, "╔═══════════════════════════════════════════════════════════════════════════════════════");
        } else {
            Log.d(tag, "╚═══════════════════════════════════════════════════════════════════════════════════════");
        }
    }

    public static void printJson(String tag, String msg, String headString) {
        String message;
        try {
            if (msg.startsWith("{")) {
                JSONObject jsonObject = new JSONObject(msg);
                message = jsonObject.toString(4);//最重要的方法，就一行，返回格式化的json字符串，其中的数字4是缩进字符数
            } else if (msg.startsWith("[")) {
                JSONArray jsonArray = new JSONArray(msg);
                message = jsonArray.toString(4);
            } else {
                message = msg;
            }
        } catch (JSONException e) {
            message = msg;
        }

        printLine(tag, true);
        message = headString + LINE_SEPARATOR + message;
        String[] lines = message.split(LINE_SEPARATOR);
        for (String line : lines) {
            Log.d(tag, "║ " + line);
        }
        printLine(tag, false);
    }


    //Android的Log等级通常有五类，按照日志级别由低到高分别是Verbose、Debug、Info、Warning、Error  等级逐步增大
    private final static int logLevel = Log.VERBOSE; //日志级别，大于或者等于logLevel才会被打印
    public static final String LOG_WRITE_NAME = "JHF";

    /**
     * 输出故障的日志信息
     *
     * @param msg 详细描述
     */
    public static void d(String msg) {
        if (isinput) {
            if (logLevel <= Log.DEBUG) {
                Log.d(LOG_WRITE_NAME, "\n 接口编写人:" + LOG_WRITE_NAME + "\n 日志信息:" + msg);
            }
        }
    }

    /**
     * 输出错误的日志信息
     *
     * @param context  系统名称模块名称接口名称
     * @param msg      详细描述
     * @param userName 接口编写人
     */
    public static void e(Context context, String msg, String userName) {
        if (isinput) {
            if (logLevel <= Log.ERROR) {
                Log.e(LOG_WRITE_NAME, "\n 接口编写人:" + LOG_WRITE_NAME + "\n 日志信息:" + msg);
            }
        }
    }

    /**
     * 输出程序的日志信息
     *
     * @param msg 详细描述
     */
    public static void i(String msg) {
        if (isinput) {
            if (logLevel <= Log.INFO) {
                Log.i(LOG_WRITE_NAME, "\n 接口编写人:" + LOG_WRITE_NAME + "\n 日志信息:" + msg);
            }
        }
    }

    /**
     * 输出冗余的日志信息
     *
     * @param msg 详细描述
     */
    public static void v(String msg) {
        if (isinput) {
            if (logLevel <= Log.VERBOSE)
                Log.v(LOG_WRITE_NAME, "\n 接口编写人:" + LOG_WRITE_NAME + "\n 日志信息:" + msg);
        }
    }

    /**
     * 输出警告的日志信息
     *
     * @param msg 详细描述
     */
    public static void w(String msg) {
        //获取手机相关信息
        String phoneMessage = PhoneMessage.getPhoneMessage(App.getContext());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        //获取错误日志信息
        String errorMessage = "\n 接口信息:" + AppUtils.getAppMessage(App.getContext()) + "\n" + "接口编写人:" + LOG_WRITE_NAME + "\n" + "错误信息为:" + msg + "\n" +
                "错误时间:" + df.format(new Date());
        //将手机信息、错误信息缓存进手机
        if (isinput) {
            if (logLevel <= Log.WARN) {
                Log.w(AppUtils.getRunningActivityName(App.getContext()), "\n 接口编写人:" + LOG_WRITE_NAME + "\n 日志信息:" + msg);
            }
        }
    }

}
