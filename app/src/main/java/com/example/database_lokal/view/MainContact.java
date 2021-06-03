package com.example.database_lokal.view;

import android.view.View;

import com.example.database_lokal.entity.AppDatabase;
import com.example.database_lokal.entity.DataKampus;

import java.util.List;

public interface MainContact {
    interface view extends View.OnClickListener{
        void successAdd();
        void successDelete();
        void resetForm();
        void getData(List<DataKampus> list);
        void editData(DataKampus item);
        void deleteData(DataKampus item);
    }
    interface presenter{
        void insertData(String nama, String alamat, String jumlah, AppDatabase database);
        void readData(AppDatabase database);
        void editData(String nama, String alamat, String jumlah, int id, AppDatabase database);
        void deleteData(DataKampus dataKampus, AppDatabase appDatabase);
    }
}
