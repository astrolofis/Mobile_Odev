package com.example.mobileodev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    Button btn_Convert, btn_Random,btn_Sms;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_Convert = findViewById(R.id.btn_Convert);
        btn_Random= findViewById(R.id.btn_Random);
        btn_Sms=findViewById(R.id.btn_Sms);

        btn_Convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, activity_Convert.class);
                startActivity(intent);
            }
        });

        btn_Random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, random_Activity.class);
                startActivity(intent);
            }
        });

        btn_Sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, sms_Activity.class);
                startActivity(intent);
            }
        });



    }

}