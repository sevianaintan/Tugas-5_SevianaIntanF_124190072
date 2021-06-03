package com.example.database_lokal.entity;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DataKampusDAO {
    @Insert
    Long insertData(com.example.database_lokal.entity.DataKampus dataKampus);

    @Query("Select * from 'kampus_db'_db")
    List<com.example.database_lokal.entity.DataKampus> getData();

    @Update
    int updateData(com.example.database_lokal.entity.DataKampus item);

    @Delete
    void deleteData(com.example.database_lokal.entity.DataKampus item);
}
