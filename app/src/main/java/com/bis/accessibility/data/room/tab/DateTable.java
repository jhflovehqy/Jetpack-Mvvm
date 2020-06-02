package com.bis.accessibility.data.room.tab;

import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "dates")
public class DateTable {


    /**
     * api : mtop.common.getTimestamp
     * v : *
     * ret : ["SUCCESS::接口调用成功"]
     * data : {"t":"1590460309258"}
     */

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "api")
    private String api;
    @ColumnInfo(name = "v")
    private String v;

    public int  getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }
}