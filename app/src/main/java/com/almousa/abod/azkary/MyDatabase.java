package com.almousa.abod.azkary;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class MyDatabase extends SQLiteAssetHelper {

    final static String DB_NAME = "azkar.db";
    final static int DB_VERSION = 1;

    // Table Azkar
    final static String TB_NAME = "azkar";
    final static String ID = "id";
    final static String TEXT = "text";
    final static String DESC = "desc";
    final static String LIMIT = "limit";
    final static String CATEGORY = "category";

    MyDatabase(Context context) {
        super(context,DB_NAME,null,DB_VERSION);
    }
}
