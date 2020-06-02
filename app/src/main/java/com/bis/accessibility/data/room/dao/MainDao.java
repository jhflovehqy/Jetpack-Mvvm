package com.bis.accessibility.data.room.dao;

import com.bis.accessibility.data.room.tab.DateTable;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Observable;

@Dao
public interface MainDao {


    /**
     * @return
     */
    @Query("SELECT * FROM DATES LIMIT 1")
    Flowable<DateTable> getDateData();


    /**
     * @param dateBean
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertDate(DateTable dateBean);


    /**
     * @return
     */
    @Query("DELETE FROM DATES")
    void deleteAllDate();

}
