package com.almousa.abod.azkary;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseAccess {

    private SQLiteDatabase dataBase;
    private SQLiteOpenHelper openHelper;
    private static DatabaseAccess instance;

    private DatabaseAccess(Context context) {
        this.openHelper = new MyDatabase(context);
    }

    public static DatabaseAccess getInstance(Context context) {
        if(instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    // To open connection to th DB
    public void open() {
        this.dataBase = this.openHelper.getWritableDatabase();
    }

    // To close the connection with th DB
    public void close() {
        if(dataBase != null) {
            this.dataBase.close();
        }
    }

    // To view the Azkar based on the category
    public ArrayList<AzkarModel> getAzkars(String AzkarCategory) {
        ArrayList<AzkarModel> azkars = new ArrayList<>();

        Cursor cursor = dataBase.rawQuery("SELECT * FROM "+MyDatabase.TB_NAME+" WHERE "+MyDatabase.CATEGORY+" =? ",
                new String[] {String.valueOf(AzkarCategory)});

        if(cursor != null && cursor.moveToFirst()) { // to check first if the array is empty
            do {
                int id = cursor.getInt(cursor.getColumnIndex(MyDatabase.ID));
                String text = cursor.getString(cursor.getColumnIndex(MyDatabase.TEXT));
                String desc = cursor.getString(cursor.getColumnIndex(MyDatabase.DESC));
                int limit = cursor.getInt(cursor.getColumnIndex(MyDatabase.LIMIT));
                String category = cursor.getString(cursor.getColumnIndex(MyDatabase.CATEGORY));

                AzkarModel azkar = new AzkarModel(id,category,text,desc,limit);
                azkars.add(azkar);
            } while (cursor.moveToNext());
            cursor.close();
        }
        return azkars;
    }
}
