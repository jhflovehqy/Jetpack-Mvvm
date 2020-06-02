package com.bis.accessibility.data.bean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

public class DateBean extends BaseObservable {


    /**
     * api : mtop.common.getTimestamp
     * v : *
     * ret : ["SUCCESS::接口调用成功"]
     * data : {"t":"1590460309258"}
     */


    @Bindable
    private String api;
    @Bindable
    private String v;
    @Bindable
    private DataBean data;
    @Bindable
    private List<String> ret;

    @Bindable
    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
        notifyPropertyChanged(BR.api);
    }
    @Bindable
    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
        notifyPropertyChanged(BR.v);
    }
    @Bindable
    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
        notifyPropertyChanged(BR.data);
    }
    @Bindable
    public List<String> getRet() {
        return ret;
    }

    public void setRet(List<String> ret) {
        this.ret = ret;
        notifyPropertyChanged(BR.ret);
    }

    public static class DataBean {
        /**
         * t : 1590460309258
         */

        private String t;

        public String getT() {
            return t;
        }

        public void setT(String t) {
            this.t = t;
        }
    }
}
