package com.bis.accessibility.bridge.callback;

import java.util.ArrayList;
import java.util.List;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {


    public static final List<String> TAG_OF_SECONDARY_PAGES = new ArrayList<>();
    public static final ObservableBoolean IS_DRAWER_OPENED = new ObservableBoolean();
    public final UnPeekLiveData<Boolean> timeToAddSlideListener = new UnPeekLiveData<>();
    public final UnPeekLiveData<Boolean> closeSlidePanelIfExpanded = new UnPeekLiveData<>();
    public final UnPeekLiveData<Boolean> activityCanBeCloseDirectly = new UnPeekLiveData<>();
    public final UnPeekLiveData<Boolean> openOrCloseDrawer = new UnPeekLiveData<>();
    public final UnPeekLiveData<Boolean> enableSwipeDrawer = new UnPeekLiveData<>();


}
