package com.example.provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyDBhelper extends SQLiteOpenHelper {
    public MyDBhelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        Log.d("zw","dbhelper 构造");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {//建表, 若没有定义数据库的访问规则，则不会运行oncreate
        db.execSQL("create table student (" +
                "id integer primary key autoincrement," +
                "name varchar(20)," +
                "age integer)");
        Log.d("zw","database oncreate");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
