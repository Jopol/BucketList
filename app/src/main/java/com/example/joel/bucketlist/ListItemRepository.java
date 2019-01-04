package com.example.joel.bucketlist;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ListItemRepository {

    private AppDataBase mAppDatabase;
    private ListItemDao mListItemDao;
    private LiveData<List<ListItem>> mListItems;
    private Executor mExecutor = Executors.newSingleThreadExecutor();

    public ListItemRepository (Context context){

        mAppDatabase = AppDataBase.getInstance(context);
        mListItemDao = ((AppDataBase) mAppDatabase).listItemDao();
        mListItems = mListItemDao.getAllListItems();
    }

    public LiveData<List<ListItem>> getAllListItems() {
        return mListItems;
    }

    public void insert(final ListItem listItem) {
        mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mListItemDao.insertItemLists(listItem);
            }
        });
    }

    public void update(final ListItem listItem) {
        mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mListItemDao.updateItemLists(listItem);
            }
        });
    }

    public void delete(final ListItem listItem) {
        mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mListItemDao.deleteItemLists(listItem);
            }
        });
    }

}
