package com.example.couim.databasetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by couim on 19/01/16.
 */
public class DataHandler extends SQLiteOpenHelper {
    private static final String PERSON = "PERSON";
    public static final String NAME = "NOM";
    public static final String SURNAME = "PRENOM";

    private static final String DBNAME = "person.db";
    private static final int DATABASE_VERSION = 1;
    public static final String DROPTABLE = "DROP TABLE IF EXISTS " + PERSON + ";";

    public static final String DATABASE_CREATE = "CREATE TABLE " + PERSON + " ("+
            NAME + " TEXT primary key, " +
            SURNAME + " TEXT);";

    public DataHandler(Context c) {
        super(c, DBNAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROPTABLE);
        onCreate(db);
    }
}
