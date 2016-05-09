package com.gudiev.hasan.rudndatabase.View;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.gudiev.hasan.rudndatabase.R;

public class SecondActivity extends AppCompatActivity {

    //Объявление переменной типа Button
    Button mCallButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Инициализация переменной и установка события при нажатии на Button
        mCallButton = (Button) findViewById(R.id.callButton);
        mCallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Вызов activity dialer уже с набрынным номером
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+7 (495) 787-38-27"));
                startActivity(intent);
            }
        });

    }
}
