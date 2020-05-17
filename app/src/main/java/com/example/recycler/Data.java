package com.example.recycler;


import android.database.MergeCursor;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.Contract;

import java.io.Serializable;

@Entity(tableName = "MyData")
public class Data implements Serializable {
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    @ColumnInfo(name = "Name")
    private String name;
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "Number")
    private String number;

    public Data(String name, String number) {
        id=0;
        this.name = name;
        this.number = number;
    }
    @Ignore
    public Data(String name, String number , int id) {
        this.id=id;
        this.name = name;
        this.number = number;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

}
