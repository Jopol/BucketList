package com.example.joel.bucketlist;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "listitem")
public class ListItem {

    @PrimaryKey(autoGenerate = true)
    private long id;
    @ColumnInfo(name = "checkbox")
    private boolean mCheckbox;
    @ColumnInfo(name = "title")
    private String mTitle;

    public ListItem(boolean mCheckbox, String mTitle) {
        this.mCheckbox = mCheckbox;
        this.mTitle = mTitle;
    }

    public boolean isCheckbox() {
        return mCheckbox;
    }

    public void setCheckbox(boolean mCheckbox) {
        this.mCheckbox = mCheckbox;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
