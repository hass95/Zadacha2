package com.gudiev.hasan.rudndatabase.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.gudiev.hasan.rudndatabase.database.DbSchema.GroupTable;
import com.gudiev.hasan.rudndatabase.database.DbSchema.StudentTable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "rudnBase.db";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + GroupTable.NAME + "("
                + GroupTable.Cols.ID + " integer primary key autoincrement, "
                + GroupTable.Cols.NAME + " text not null"
                + ")"
        );

        db.execSQL("create table " + StudentTable.NAME + "("
                + StudentTable.Cols.ID + " integer primary key autoincrement, "
                + StudentTable.Cols.NAME + " text not null, "
                + StudentTable.Cols.GROUP_ID + " integer not null, "
                + "foreign key(" + StudentTable.Cols.GROUP_ID + ") "
                + "references " + GroupTable.NAME + " (" + GroupTable.Cols.ID + ")"
                + ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + GroupTable.NAME);
        db.execSQL("drop table if exists " + StudentTable.NAME);
        onCreate(db);
    }
}
