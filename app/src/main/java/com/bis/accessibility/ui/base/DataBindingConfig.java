package com.bis.accessibility.ui.base;

import android.util.SparseArray;

import androidx.lifecycle.ViewModel;

public class DataBindingConfig {

    /**
     * layoutId:视图ID
     * stateViewModel:ViewModel
     * bingingParams:绑定参数
     */
    private int layoutId;

    private ViewModel stateViewModel;

    private SparseArray bingingParams = new SparseArray();

    public DataBindingConfig(int layoutId, ViewModel stateViewModel) {
        this.layoutId = layoutId;
        this.stateViewModel = stateViewModel;
    }

    public int getLayoutId() {
        return layoutId;
    }

    public ViewModel getStateViewModel() {
        return stateViewModel;
    }

    public SparseArray getBingingParams() {
        return bingingParams;
    }

    /**
     * 添加绑定参数
     * @param variableId
     * @param object
     * @return
     */
    public DataBindingConfig addBingingParam(int variableId , Object object){
        if(bingingParams.get(variableId) == null){
            bingingParams.put(variableId , object);
        }
        return this;
    }
}
