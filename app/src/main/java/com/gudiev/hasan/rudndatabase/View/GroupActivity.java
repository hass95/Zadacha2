package com.gudiev.hasan.rudndatabase.View;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.gudiev.hasan.rudndatabase.R;
import com.gudiev.hasan.rudndatabase.Model.Group;
import com.gudiev.hasan.rudndatabase.adapter.GroupAdapter;
import com.gudiev.hasan.rudndatabase.database.GroupRepo;

public class GroupActivity extends AppCompatActivity {

    private GroupAdapter groupAdapter;
    ListView listView;
    Cursor cursor;
    GroupRepo groupRepo ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        groupRepo = new GroupRepo(this);
        cursor = groupRepo.getStudentList();
        groupAdapter = new GroupAdapter(GroupActivity.this,  cursor, 0);
        if(cursor == null) insertDummy();
        listView = (ListView) findViewById(R.id.groupList);
        if (listView != null) listView.setAdapter(groupAdapter);
        onListItemClick();

    }

    private void onListItemClick() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(GroupActivity.this, StudentActivity.class);
                    intent.putExtra("gpId", 1);
                    startActivity(intent);
                }
                if (position == 1) {
                    Intent intent = new Intent(GroupActivity.this, StudentActivity.class);
                    intent.putExtra("gpId", 2);
                    startActivity(intent);
                }
            }
        });
    }

    private void insertDummy(){
        Group group= new Group();

        group.setName("Группа 1");
        groupRepo.insert(group);

        groupRepo = new GroupRepo(this);
        group.setName("Группа 2");
        groupRepo.insert(group);
    }
}