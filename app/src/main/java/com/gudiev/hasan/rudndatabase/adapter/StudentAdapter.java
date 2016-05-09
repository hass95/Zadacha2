package com.gudiev.hasan.rudndatabase.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.gudiev.hasan.rudndatabase.R;
import com.gudiev.hasan.rudndatabase.database.DbSchema;

import static com.gudiev.hasan.rudndatabase.database.DbSchema.*;

public class StudentAdapter extends CursorAdapter{
    private LayoutInflater mInflater;

    public StudentAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = mInflater.inflate(R.layout.item_student, parent, false);
        ViewHolder holder = new ViewHolder();
        holder.txtName = (TextView) view.findViewById(R.id.studentName);
        view.setTag(holder);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder holder = (ViewHolder) view.getTag();
        holder.txtName.setText(cursor.getString(cursor.getColumnIndex(StudentTable.Cols.NAME)));
    }

    static class ViewHolder {
        TextView txtId;
        TextView txtName;
    }
}
