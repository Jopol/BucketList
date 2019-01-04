package com.example.joel.bucketlist;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import java.util.List;

public class MainViewModel {

    private ListItemRepository mRepository;

    private LiveData<List<ListItem>> mListItems;


    public MainViewModel(Context context) {

        mRepository = new ListItemRepository(context);

        mListItems = mRepository.getAllListItems();

    }


    public LiveData<List<ListItem>> getListItems() {

        return mListItems;

    }


    public void insert(ListItem listItem) {

        mRepository.insert(listItem);

    }


    public void update(ListItem listItem) {

        mRepository.update(listItem);

    }


    public void delete(ListItem listItem) {

        mRepository.delete(listItem);

    }
}

