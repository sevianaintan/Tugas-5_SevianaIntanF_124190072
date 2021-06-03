package com.example.database_lokal.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "kampus_db")
public class DataKampus {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
        private int id;
    @ColumnInfo(name = "name")
        private String name;
    @ColumnInfo(name = "address")
        private String address;
    @ColumnInfo(name = "jumlah")
        private String mhs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMhs() {
        return mhs;
    }

    public void setMhs(String mhs) {
        this.mhs = mhs;
    }



}
