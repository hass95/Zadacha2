package com.gudiev.hasan.rudndatabase.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gudiev.hasan.rudndatabase.R;

public class MainActivity extends AppCompatActivity {

    //Объявление переменных типа Button
    Button mInfoButton;
    Button mGroupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Инициализация переменной mInfoButton и установка события при нажатии на Button
        mInfoButton = (Button) findViewById(R.id.infoButton);
        mInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Переход на SecondActivity
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        //Инициализация переменной mGroupButton и установка события при нажатии на Button
        mGroupButton = (Button) findViewById(R.id.groupButton);
        mGroupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Переход на GroupActivity
                Intent intent = new Intent(MainActivity.this, GroupActivity.class);
                startActivity(intent);
            }
        });
    }
}
