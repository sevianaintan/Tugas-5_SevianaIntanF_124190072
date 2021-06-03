package com.example.database_lokal.view;

import android.os.AsyncTask;
import android.util.Log;

import com.example.database_lokal.entity.AppDatabase;
import com.example.database_lokal.entity.DataKampus;

import java.util.List;

public class MainPresenter implements com.example.database_lokal.view.MainContact.presenter {
    private com.example.database_lokal.view.MainContact.view view;

    public MainPresenter(com.example.database_lokal.view.MainContact.view view){
        this.view=view;
    }
    class InsertData extends AsyncTask<Void,Void,Long> {
        private AppDatabase appDatabase;
        private DataKampus dataKampus;

        public InsertData(AppDatabase appDatabase, DataKampus dataKampus){
            this.appDatabase = appDatabase;
            this.dataKampus = dataKampus;
        }

        @Override
        protected Long doInBackground(Void... voids) {
            return appDatabase.dao().insertData(dataKampus);
        }
        protected void onPostExecute(Long along){
            super.onPostExecute(along);
            view.successAdd();
        }
    }

    @Override
    public void insertData(String nama, String alamat, String jumlah, AppDatabase database) {
        final DataKampus dataKampus = new DataKampus();
        dataKampus.setName(nama);
        dataKampus.setAddress(alamat);
        dataKampus.setMhs(jumlah);
        new InsertData(database, dataKampus).execute();
    }

    @Override
    public void readData(AppDatabase database) {
        List<DataKampus> list;
        list = database.dao().getData();
        view.getData(list);

    }


    class EditData extends AsyncTask<Void, Void, Integer>{
        private AppDatabase appDatabase;
        private DataKampus dataKampus;
        public EditData(AppDatabase appDatabase, DataKampus dataKampus){
            this.appDatabase=appDatabase;
            this.dataKampus=dataKampus;
        }

        @Override
        protected Integer doInBackground(Void... voids) {
            return appDatabase.dao().updateData(dataKampus);
        }
        protected void onPostExecute(Integer integer){
            super.onPostExecute(integer);
            Log.d("integer db", "onPostExecute : "+integer);
            view.successAdd();
        }
    }

    @Override
    public void editData(String nama, String alamat, String jumlah, int id, AppDatabase database) {
        final DataKampus dataKampus = new DataKampus();
        dataKampus.setName(nama);
        dataKampus.setAddress(alamat);
        dataKampus.setMhs(jumlah);
        dataKampus.setId(id);
        new EditData(database,dataKampus).execute();
    }
    class DeleteData extends AsyncTask<Void, Void, Long>{
        private AppDatabase appDatabase;
        private DataKampus dataKampus;
        public DeleteData(AppDatabase appDatabase, DataKampus dataKampus){
            this.appDatabase=appDatabase;
            this.dataKampus=dataKampus;
        }

        @Override
        protected Long doInBackground(Void... voids) {
            appDatabase.dao().deleteData(dataKampus);
            return null;
        }
        protected void onPostExecute(Long along){
            super.onPostExecute(along);
            view.successDelete();
        }
    }

    @Override
    public void deleteData(DataKampus dataKampus, AppDatabase appDatabase) {
        new DeleteData(appDatabase, dataKampus).execute();

    }


}
