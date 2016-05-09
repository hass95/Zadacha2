package com.gudiev.hasan.rudndatabase.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.gudiev.hasan.rudndatabase.Model.Student;

import static com.gudiev.hasan.rudndatabase.database.DbSchema.*;

public class StudentRepo {

    private DatabaseHelper databaseHelper;

    public StudentRepo(Context context) {
        databaseHelper = new DatabaseHelper(context);
    }

    public int insert(Student student) {

        //Open connection to write data
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(StudentTable.Cols.NAME, student.getName());
        values.put(StudentTable.Cols.GROUP_ID, student.getGp());

        // Inserting Row
        long student_Id = db.insert(StudentTable.NAME, null, values);
        db.close(); // Closing database connection
        return (int) student_Id;
    }

    public Cursor getStudentList(int gpId) {
        //Open connection to read only
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        String selectQuery =  "SELECT  rowid as " +
                StudentTable.Cols.ID + "," +
                StudentTable.Cols.NAME + "," +
                StudentTable.Cols.GROUP_ID +
                " FROM " + StudentTable.NAME +
                " WHERE " + StudentTable.Cols.GROUP_ID + " = " + gpId;


        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor == null) {
            return null;
        } else if (!cursor.moveToFirst()) {
            cursor.close();
            return null;
        }
        return cursor;

    }


}
