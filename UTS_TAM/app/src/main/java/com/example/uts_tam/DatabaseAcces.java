package com.example.uts_tam;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatabaseAcces {
    private SQLiteDatabase database;
    private DatabaseOpenHelper openHelper;
    private static volatile DatabaseAcces instance;

    private DatabaseAcces(Context context){
        this.openHelper = new DatabaseOpenHelper(context);
    }

    public static synchronized DatabaseAcces getInstance(Context context){
        if (instance == null){
            instance = new DatabaseAcces(context);
        }
        return instance;
    }

    public void open(){
        this.database = openHelper.getWritableDatabase();
    }

    public void close(){
        if (database != null){
            this.database.close();
        }
    }

    public void save(Memo memo){
        ContentValues values = new ContentValues();
        values.put("date", memo.getTime());
        values.put("memo", memo.getText());
        database.insert(DatabaseOpenHelper.TABLE,null,values);

    }

    public void update(Memo memo){
        ContentValues values = new ContentValues();
        values.put("date", new Date().getTime());
        values.put("memo", memo.getText());
        String date = Long.toString(memo.getTime());
        database.update(DatabaseOpenHelper.TABLE,values, "date = ?", new String[]{date});

    }

    public void delete(Memo memo){
        String date = Long.toString(memo.getTime());
        database.delete(DatabaseOpenHelper.TABLE, "date = ?", new String[]{date});
    }

    public List getAllMemos(){
        List memos = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * From memo ORDER BY date DESC", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            long time = cursor.getLong(0);
            String text = cursor.getString(1);
            memos.add(new Memo(time, text));
            cursor.moveToNext();
        }

        cursor.close();
        return memos;
    }
}