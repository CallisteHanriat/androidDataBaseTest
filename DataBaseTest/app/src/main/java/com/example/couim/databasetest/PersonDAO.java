package com.example.couim.databasetest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import java.sql.SQLException;

/**
 * Created by couim on 19/01/16.
 */
public class PersonDAO {
    private SQLiteDatabase database;
    private DataHandler dataHandler;
    private String[] allColumns = {DataHandler.NAME, DataHandler.SURNAME};

    public PersonDAO(Context context) {
        dataHandler = new DataHandler(context);
    }

    public void open() throws SQLException{
        database = dataHandler.getWritableDatabase();
    }

    public void close() {
        dataHandler.close();
    }

    public Person findPersonInDb(String name) {
        ContentValues values = new ContentValues();
        values.put(DataHandler.NAME, name);
        Cursor cursor = database.rawQuery("Select * From Person Where name = ?" , new String[]{name});
        if(cursor.getCount() == 0) {
            return null;
        }
        cursor.moveToFirst();
        Person p = new Person(name, cursor.getString(1));
        return p;
    }

    public void insertPerson(Person p) {
        try {
            database.beginTransaction();
            ContentValues values = new ContentValues();
            values.put(DataHandler.NAME, p.getName());
            values.put(DataHandler.SURNAME, p.getSurname());
            database.insert("Person", null, values);
            database.endTransaction();

            System.out.println("Insertion réussite");
            Log.d("GOOD", "Insertin réussite");
        } catch (Exception e) {
            Log.e("insertion Bug", "Bug for insertion of a personage");
        }
    }
}
