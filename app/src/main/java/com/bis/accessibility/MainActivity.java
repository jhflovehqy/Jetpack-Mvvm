package com.bis.accessibility;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import com.bis.accessibility.data.bean.DateBean;
import com.bis.accessibility.data.repository.MainRepository;
import com.bis.accessibility.data.room.source.dao.MainDataSource;
import com.bis.accessibility.data.room.tab.DateTable;
import com.bis.accessibility.databinding.ActivityMainBinding;
import com.bis.accessibility.ui.base.AutoWired;
import com.bis.accessibility.ui.base.BaseActivity;
import com.bis.accessibility.ui.base.DataBindingConfig;
import com.bis.accessibility.ui.viewmodel.DateViewModel;
import com.bis.accessibility.ui.viewmodel.MainViewModel;

import androidx.lifecycle.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

public class MainActivity extends BaseActivity<ActivityMainBinding> {


    private MainViewModel mainViewModel;
    private DateViewModel dateViewModel;
    @AutoWired
    DateBean dateBean;
    @AutoWired
    MainRepository mainRepository;
    MainDataSource mainDataSource;


    @Override
    protected void initViewModel() {
        mainViewModel = getActivityViewModel(MainViewModel.class);
        dateViewModel = getActivityViewModel(DateViewModel.class);
    }

    @Override
    protected DataBindingConfig getDataBingingConfig() {
        return new DataBindingConfig(R.layout.activity_main, mainViewModel)
                .addBingingParam(BR.click, new ClickProxy())
                .addBingingParam(BR.date, dateViewModel);
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        mainViewModel.getDateShowData().observe(this, new Observer<DateBean>() {
            @SuppressLint("CheckResult")
            @Override
            public void onChanged(DateBean dateBeans) {
                DateTable dateTable = new DateTable();
                dateTable.setApi("1111");
                dateTable.setV("2222");


//                DateInjection.createDataBase(MainActivity.this, dateTable);

                mainDataSource.insertDate(dateTable)
                        .subscribeOn(io.reactivex.schedulers.Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(() -> Log.d("JHF", "成功"), new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                Log.d("JHF", throwable.toString());
                            }
                        });

                mainDataSource.getDateData()
                        .subscribeOn(io.reactivex.schedulers.Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<DateTable>() {
                            @Override
                            public void accept(DateTable dateTable) throws Exception {
                                Log.d("JHF", dateTable.toString());
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                Log.d("JHF", throwable.toString());
                            }
                        });


                dateBean.setApi("我要开始更新啦！");
                showLongToast("我要开始更新数据啦！");
            }
        });


    }


    public class ClickProxy {


        public void getDate() {
            dateViewModel.loadDateShowData();
        }
    }


}
