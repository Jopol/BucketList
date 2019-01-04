package com.example.joel.bucketlist;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface ListItemDao {

    @Query("SELECT * FROM listitem")
    public LiveData<List<ListItem>> getAllListItems();

    @Insert
    public void insertItemLists(ListItem listItem);

    @Delete
    public void deleteItemLists(ListItem listItem);

    @Update
    public void updateItemLists(ListItem listItem);


}
