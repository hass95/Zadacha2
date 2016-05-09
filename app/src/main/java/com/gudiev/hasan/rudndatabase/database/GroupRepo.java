package com.gudiev.hasan.rudndatabase.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.gudiev.hasan.rudndatabase.Model.Group;

import static com.gudiev.hasan.rudndatabase.database.DbSchema.*;

public class GroupRepo {

    private DatabaseHelper databaseHelper;

    public GroupRepo(Context context) {
        databaseHelper = new DatabaseHelper(context);
    }

    public int insert(Group group) {

        //Open connection to write data
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(GroupTable.Cols.NAME, group.getName());

        // Inserting Row
        long student_Id = db.insert(GroupTable.NAME, null, values);
        db.close();
        return (int) student_Id;
    }
    public Cursor getStudentList() {
        //Open connection to read only
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        String selectQuery =  "SELECT  rowid as " +
                GroupTable.Cols.ID + "," +
                GroupTable.Cols.NAME +
                " FROM " + GroupTable.NAME;


        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor == null) {
            return null;
        } else if (!cursor.moveToFirst()) {
            cursor.close();
            return null;
        }
        return cursor;

    }


    public Cursor getStudentListByKeyword(String search) {
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        String selectQuery = "SELECT rowid as " +
                GroupTable.Cols.ID + "," +
                GroupTable.Cols.NAME +
                " FROM " + GroupTable.NAME +
                " WHERE " + GroupTable.Cols.NAME + " LIKE '%" +search + "%' ";


        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor == null) {
            return null;
        } else if (!cursor.moveToFirst()) {
            cursor.close();
            return null;
        }
        return cursor;
    }

    public Group getStudentById(int Id){
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        String selectQuery = "SELECT " +
                GroupTable.Cols.ID + "," +
                GroupTable.Cols.NAME +
                " FROM " + GroupTable.NAME +
                " WHERE " + GroupTable.Cols.ID + "=?";

        int iCount =0;
        Group group = new Group();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(Id) } );

        if (cursor.moveToFirst()) {
            do {
                group.setName(cursor.getString(cursor.getColumnIndex(GroupTable.Cols.NAME)));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return group;
    }
}
