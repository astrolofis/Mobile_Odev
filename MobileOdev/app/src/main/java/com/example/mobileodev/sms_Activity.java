package com.example.mobileodev;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sms_Activity extends AppCompatActivity {

    EditText input_message, input_phone;
    Button btn_Send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        input_message=findViewById(R.id.input_messasage);
        input_phone=findViewById(R.id.input_phone);
        btn_Send=findViewById(R.id.btn_Send);

        btn_Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input_message.getText().toString().isEmpty()!=true&&
                input_phone.getText().toString().isEmpty()!=true){
                    String phoneNumber = input_phone.getText().toString();
                    String message=input_message.getText().toString();

                    sendMessage(phoneNumber,message);
                }else{
                    input_message.setText("Bir Hata Oluştu");
                }
            }
        });



    }

    public void sendMessage(String phoneNumber,String message){
        try{
            SmsManager smsManager= SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber,null,message,null,null);
        }catch(Exception e){
            Toast.makeText(getApplicationContext(),"Bir Hata Oluştu",Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

    }

}