package com.bis.accessibility.http.retrofit;

import android.util.Log;

import com.bis.accessibility.utils.Constant;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.android.BuildConfig;

/**
 * time : 2019/8/7
 * name : 江海锋
 * 用来初始化Retrofit构建，通过getInstance()方法和getRetrofitApiService()方法暴露给外部使用
 * <p>
 * 修改日志:
 */
public class RetrofitHttp {

    public final static RetrofitHttp mRetrofit = new RetrofitHttp();


    public static int TIMEOUT_CONNECT = 50;
    public static int TIMEOUT_WRITE = 50;
    public static int TIMEOUT_READ = 50;
    public static boolean isPy = false;

    /**
     * 线程安全的单例模式写法
     */
    public static RetrofitHttp getInstance() {
        return mRetrofit;
    }



    /**
     * @return
     */
    public static HttpService getResponse() {
        getInstance();
        return new Retrofit.Builder()
                .baseUrl(Constant.REQUEST_URL)
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(HttpService.class);
    }


    /**
     * @return
     */
    public static OkHttpClient getOkHttpClient() {
        Interceptor interceptor = chain -> {
            Request request = chain.request().newBuilder().build();
            Log.i("url-----", request.toString());
            return chain.proceed(request);
        };
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        //调试模式打印日志
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addNetworkInterceptor(logging);
        }

        //.proxy(java.net.Proxy.NO_PROXY); 防抓包，不设置代理
        return builder.connectTimeout(TIMEOUT_CONNECT, TimeUnit.SECONDS) //连接超时时间
                .writeTimeout(TIMEOUT_READ, TimeUnit.SECONDS)   //写入超时时间
                .readTimeout(TIMEOUT_WRITE, TimeUnit.SECONDS)    //读取超时时间
                .addInterceptor(interceptor) //添加拦截器
                .build();
    }


}

