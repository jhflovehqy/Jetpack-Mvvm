package com.bis.accessibility.data.repository;

import android.content.Context;
import android.util.Log;

import com.bis.accessibility.data.bean.DateBean;
import com.bis.accessibility.data.room.DateInjection;
import com.bis.accessibility.http.retrofit.RetrofitHttp;
import com.bis.accessibility.ui.viewmodel.MainViewModel;

import androidx.lifecycle.MutableLiveData;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MainRepository extends BaseRepository{


    public final static MainRepository MAIN_REPOSITORY = new MainRepository();


    public static MainRepository getInstance(){
        return MAIN_REPOSITORY;
    }



    public void   loadMainData(MutableLiveData<DateBean> dateBeanMutableLiveData) {
        RetrofitHttp.getResponse().getDateTime()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<DateBean>() {
                               @Override
                               public void call(DateBean dateBean) {
                                   dateBeanMutableLiveData.postValue(dateBean);
                               }
                           },
                        throwable -> Log.i("TAG", throwable.toString()));
    }

    public void   loadMainDatas(MutableLiveData<String> api) {
        RetrofitHttp.getResponse().getDateTime()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<DateBean>() {
                               @Override
                               public void call(DateBean dateBean) {
                                   api.setValue(dateBean.getApi());
                               }
                           },
                        throwable -> Log.i("TAG", throwable.toString()));
    }
}
