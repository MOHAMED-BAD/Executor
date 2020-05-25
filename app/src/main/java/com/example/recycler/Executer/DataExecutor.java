package com.example.recycler.Executer;

import android.content.Intent;

import com.example.recycler.AsynTask.DataAsync;
import com.example.recycler.Data;
import com.example.recycler.Database.DataDao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class DataExecutor  {
    private DataDao dao;
    private Executor executor= Executors.newSingleThreadExecutor();
    private DataAsync.CallBackData callBackData;

    public DataExecutor(DataDao dao , DataAsync.CallBackData callBackData) {
        this.dao = dao;
        this.callBackData=callBackData;
    }
    public void executeData(){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                List<Data> datas=dao.getDatas();
                callBackData.getCallBack(datas);
            }
        });
    }
    public void addData(final Data data){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                dao.insertData(data);
                List<Data> datas=dao.getDatas();
                callBackData.getCallBack(datas);
            }
        });
    }
    public void editData(final Data data){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                dao.updataData(data);
                List<Data> datas=dao.getDatas();
                callBackData.getCallBack(datas);
            }
        });
    }
    public void delData(final Data data){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                dao.delete(data);
                List<Data> datas = dao.getDatas();
                callBackData.getCallBack(datas);
            }
            });

}
    }
