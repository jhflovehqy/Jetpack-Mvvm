package com.bis.accessibility.data.room.source.dao;

import com.bis.accessibility.data.room.tab.DateTable;

import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Observable;

public interface MainDataSource {


    /**
     * @return
     */
    Flowable<DateTable> getDateData();


    /**
     * @param dateBean
     */
    Completable insertDate(DateTable dateBean);


    /**
     * @return
     */
    void deleteAllDate();

}
