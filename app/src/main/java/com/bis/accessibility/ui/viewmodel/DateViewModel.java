package com.bis.accessibility.ui.viewmodel;

import com.bis.accessibility.data.bean.DateBean;
import com.bis.accessibility.data.repository.MainRepository;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DateViewModel extends ViewModel {

    public MutableLiveData<DateBean> dateBeanMutableLiveData = new MutableLiveData<>();


    public void loadDateShowData() {
        MainRepository.getInstance().loadMainData(dateBeanMutableLiveData);
    }
}

