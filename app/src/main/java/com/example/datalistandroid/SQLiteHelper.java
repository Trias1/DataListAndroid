package com.example.datalistandroid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLiteHelper extends SQLiteOpenHelper {

    private static String DATABASE_NAME = "db.b";
    private static int DATABASE_VERSION = 1;

    public SQLiteHelper(Context context){
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    String sql = "create table kota( id integer primary key autoincrement, nama text null, " + "nim text null, asal text null);";
    Log.d("Data","oncreate: " +sql);
    db.execSQL(sql);
    sql = " INSERT INTO kota (id, nama, nim, asal) VALUES (1,'Trias','183112700650088','jakarta');";
    db.execSQL(sql);
    sql = " INSERT INTO kota (id, nama, nim, asal) VALUES (2,'Zaen','183112700650089','jakarta');";
    db.execSQL(sql);
    sql = " INSERT INTO kota (id, nama, nim, asal) VALUES (3,'Zaenn','183112700650189','jakarta');";
    db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method sub
    }
}