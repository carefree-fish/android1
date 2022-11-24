package com.example.provider;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

//数据处理层，进行数据库上的增删改查
public class MyDAO {

    private Context context;
    private SQLiteDatabase database;

    public MyDAO(Context context) {
        this.context=context;
        MyDBhelper dBhelper=new MyDBhelper(context,"zwDB",null,1);
        database=dBhelper.getWritableDatabase();

    }

    public Uri DAOinsert(ContentValues contentValues){
        long rowid= database.insert("student",null,contentValues);//返回insert操作的行

        Uri uri=Uri.parse("content://zw.provider");//这里加行，但是不能直接用String+String来加
        //Uri inserturi= ContentUris.appendId(uri,rowid);
        Uri inserturi=ContentUris.withAppendedId(uri,rowid);
        //定长为String，不定长为builder,
        // uri定长时用withappendId，不定长时用appendId
        context.getContentResolver().notifyChange(inserturi,null);
        return inserturi;
    }
}
