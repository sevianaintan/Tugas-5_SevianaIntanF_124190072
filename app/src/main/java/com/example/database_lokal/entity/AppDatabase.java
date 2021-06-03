package com.example.database_lokal.entity;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {com.example.database_lokal.entity.DataKampus.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DataKampusDAO dao();
    private static com.example.database_lokal.entity.AppDatabase appDatabase;

    public static com.example.database_lokal.entity.AppDatabase inidb(Context context){
        if (appDatabase==null)
            appDatabase = Room.databaseBuilder(context, com.example.database_lokal.entity.AppDatabase.class,"dbkampus").allowMainThreadQueries().build();
        return appDatabase;

    }
}
