package com.bis.accessibility.ui.base;

import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.Toast;

import com.bis.accessibility.app.App;
import com.bis.accessibility.bridge.callback.SharedViewModel;
import com.bis.accessibility.data.manager.NetworkStateManager;
import com.bis.accessibility.utils.system.AdaptScreenUtils;
import com.bis.accessibility.utils.system.BarUtils;
import com.bis.accessibility.utils.system.ScreenUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public abstract class BaseActivity<ViewDataBind extends ViewDataBinding> extends AppCompatActivity {


    SharedViewModel mSharedViewModel;
    private ViewModelProvider mActivityProvider;
    protected ViewDataBind mBinding;


    protected abstract void initViewModel();

    protected abstract DataBindingConfig getDataBingingConfig();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BarUtils.setStatusBarColor(this, Color.TRANSPARENT);
        BarUtils.setStatusBarLightMode(this, true);

        AutoWiredProcess.bind(this);
        mSharedViewModel = ((App) getApplicationContext()).getAppViewModelProvider(this).
                get(SharedViewModel.class);
        getLifecycle().addObserver(NetworkStateManager.getInstance());

        initViewModel();

        DataBindingConfig dataBindingConfig = getDataBingingConfig();
        ViewDataBind binding = DataBindingUtil.setContentView(this, dataBindingConfig.getLayoutId());
        binding.setLifecycleOwner(this);

        SparseArray bindingParams = dataBindingConfig.getBingingParams();
        for (int i = 0, length = bindingParams.size(); i < length; i++) {
            binding.setVariable(bindingParams.keyAt(i), bindingParams.valueAt(i));
        }
        mBinding = binding;
    }

    /**
     * 是否为Debug模式
     *
     * @return
     */
    public boolean isDebug() {
        return getApplicationContext().getApplicationInfo() != null &&
                (getApplicationContext().getApplicationInfo().flags &
                        ApplicationInfo.FLAG_DEBUGGABLE) != 0;
    }


    @Override
    public Resources getResources() {
        if (ScreenUtils.isPortrait()) {
            return AdaptScreenUtils.adaptWidth(super.getResources(), 360);
        } else {
            return AdaptScreenUtils.adaptHeight(super.getResources(), 640);
        }
    }

    protected void showLongToast(String text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
    }

    protected void showShortToast(String text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    }

    protected void showLongToast(int stringRes) {
        showLongToast(getApplicationContext().getString(stringRes));
    }

    protected void showShortToast(int stringRes) {
        showShortToast(getApplicationContext().getString(stringRes));
    }

    protected <T extends ViewModel> T getActivityViewModel(@NonNull Class<T> tClass) {
        if (mActivityProvider == null) {
            mActivityProvider = new ViewModelProvider(this);
        }
        return mActivityProvider.get(tClass);
    }

    public SharedViewModel getSharedViewModel() {
        return mSharedViewModel;
    }
}


















