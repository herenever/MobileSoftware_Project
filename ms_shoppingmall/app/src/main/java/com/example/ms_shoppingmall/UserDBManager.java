package com.example.ms_shoppingmall;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class UserDBManager extends SQLiteOpenHelper {
    static final String USER_DB = "Users.db";
    static final String USER_TABLE = "Users";
    Context context = null;
    private static UserDBManager dbManager = null;
    static final String CREATE_DB = " CREATE TABLE " + USER_TABLE + "(_id INTEGER PRIMARY KEY AUTOINCREMENT, " + " email TEXT NOT NULL, password TEXT NOT NULL,name TEXT);";

    public static UserDBManager getInstance(Context context){
        if(dbManager == null){
            dbManager = new UserDBManager(context,USER_DB,null,1);
        }
        return dbManager;
    }



    public UserDBManager(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_DB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    public long insert(ContentValues addValue){
        return getWritableDatabase().insert(USER_TABLE,null,addValue);
    }

    public Cursor query(String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy) {
        return getReadableDatabase().query(USER_TABLE,
                columns, selection, selectionArgs, groupBy, having, orderBy);
    }

    public int delete(String whereClause, String[] whereArgs) {
        return getWritableDatabase().delete(USER_TABLE,
                whereClause, whereArgs);
    }

}
