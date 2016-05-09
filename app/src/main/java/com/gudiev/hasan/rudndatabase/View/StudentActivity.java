package com.gudiev.hasan.rudndatabase.View;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.gudiev.hasan.rudndatabase.Model.Group;
import com.gudiev.hasan.rudndatabase.Model.Student;
import com.gudiev.hasan.rudndatabase.R;
import com.gudiev.hasan.rudndatabase.adapter.StudentAdapter;
import com.gudiev.hasan.rudndatabase.database.GroupRepo;
import com.gudiev.hasan.rudndatabase.database.StudentRepo;

public class StudentActivity extends AppCompatActivity {

    private StudentAdapter studentAdapter;
    ListView listView;
    Cursor cursor;
    StudentRepo studentRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        studentRepo = new StudentRepo(this);
        cursor = studentRepo.getStudentList(getIntent().getIntExtra("gpId", 1));
        studentAdapter = new StudentAdapter(StudentActivity.this,  cursor, 0);
        listView = (ListView) findViewById(R.id.studentList);
        if (listView != null) listView.setAdapter(studentAdapter);
        if(cursor==null) insertDummy();
    }

    private void insertDummy(){
        Student student= new Student();

        student.setName("Павел");
        student.setGp(1);
        studentRepo.insert(student);

        studentRepo = new StudentRepo(this);
        student.setName("Антон");
        student.setGp(2);
        studentRepo.insert(student);

        studentRepo = new StudentRepo(this);
        student.setName("Илья");
        student.setGp(1);
        studentRepo.insert(student);

        studentRepo = new StudentRepo(this);
        student.setName("Алексей");
        student.setGp(1);
        studentRepo.insert(student);

        studentRepo = new StudentRepo(this);
        student.setName("Валентин");
        student.setGp(2);
        studentRepo.insert(student);

        studentRepo = new StudentRepo(this);
        student.setName("Яков");
        student.setGp(2);
        studentRepo.insert(student);

        student.setName("Николай");
        student.setGp(1);
        studentRepo.insert(student);

        studentRepo = new StudentRepo(this);
        student.setName("Даниил");
        student.setGp(2);
        studentRepo.insert(student);

        studentRepo = new StudentRepo(this);
        student.setName("Георгий");
        student.setGp(1);
        studentRepo.insert(student);

        studentRepo = new StudentRepo(this);
        student.setName("Богдан");
        student.setGp(1);
        studentRepo.insert(student);

        studentRepo = new StudentRepo(this);
        student.setName("Роман");
        student.setGp(2);
        studentRepo.insert(student);

        studentRepo = new StudentRepo(this);
        student.setName("Владислав");
        student.setGp(2);
        studentRepo.insert(student);
    }
}