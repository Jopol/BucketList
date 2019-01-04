package com.example.joel.bucketlist;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.Room;
import android.content.Context;

@Database(entities = {ListItem.class}, version = 1, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {


    public abstract ListItemDao listItemDao();

    private final static String NAME_DATABASE = "listitem_db";


    //Static instance
    private static AppDataBase sInstance;

    public static AppDataBase getInstance(Context context) {

        if (sInstance == null) {
            sInstance = Room.databaseBuilder(context, AppDataBase.class, NAME_DATABASE)
                    .build();

        }


        return sInstance;

    }

}