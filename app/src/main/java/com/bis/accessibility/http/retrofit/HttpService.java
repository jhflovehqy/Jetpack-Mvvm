package com.bis.accessibility.http.retrofit;

import com.bis.accessibility.data.bean.DateBean;

import retrofit2.http.GET;
import rx.Observable;

/**
 * @姓名 江海锋
 * @时间 2020/4/28 8:53
 * @作用 Retrofit 工具管理类
 */
public interface HttpService {



    @GET("rest/api3.do?api=mtop.common.getTimestamp")
    Observable<DateBean> getDateTime();

}
