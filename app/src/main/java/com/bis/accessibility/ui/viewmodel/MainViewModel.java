package com.bis.accessibility.ui.viewmodel;

import com.bis.accessibility.data.bean.DateBean;
import com.bis.accessibility.data.repository.MainRepository;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    public MutableLiveData<DateBean> dateShowData = new MutableLiveData<>();


    public MutableLiveData<DateBean> getDateShowData() {
        return dateShowData;
    }

    public void loadDateShowData() {
        MainRepository.getInstance().loadMainData(getDateShowData());
    }


}
