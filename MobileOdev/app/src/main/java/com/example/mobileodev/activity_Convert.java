package com.example.mobileodev;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class activity_Convert extends AppCompatActivity {

    EditText input_Dec, input_Mega, input_Cel;
    Spinner spin_Dec, spin_Mega;
    Button btn_Dec, btn_Mega, btn_Cel;
    TextView dec_result, mega_Result, cel_Result;
    RadioButton fah_Radio, kel_Radio;

    String [] spin_Dec_Values={"Binary", "Oktal", "Hexadecimal"};

    String [] spin_Mega_Values={"KB", "Byte", "Bit"};

    ArrayAdapter<String> decimalAdapter,megaByteAdapter;

    String sValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);
        //Decimal
        input_Dec=findViewById(R.id.input_Dec);
        spin_Dec=findViewById(R.id.spin_Dec);
        btn_Dec=findViewById(R.id.btn_Dec);
        dec_result=findViewById(R.id.dec_Result);

        decimalAdapter=new ArrayAdapter<String>(this, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item,spin_Dec_Values);
        spin_Dec.setAdapter(decimalAdapter);

        //Mega Byte
        input_Mega=findViewById(R.id.input_Mega);
        spin_Mega=findViewById(R.id.spin_Mega);
        btn_Mega=findViewById(R.id.btn_Mega);
        mega_Result=findViewById(R.id.mega_Result);

        megaByteAdapter=new ArrayAdapter<String>(this, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item,spin_Mega_Values);
        spin_Mega.setAdapter(megaByteAdapter);

        //Celcius
        input_Cel=findViewById(R.id.input_Cel);
        btn_Cel=findViewById(R.id.btn_Cel);
        cel_Result=findViewById(R.id.cel_Result);
        fah_Radio=findViewById(R.id.fah_Radio);
        kel_Radio=findViewById(R.id.kel_Radio);


        convert_Methods convert= new convert_Methods();

        btn_Dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input_Dec.getText().toString().isEmpty()!=true) {
                    sValue = spin_Dec.getSelectedItem().toString();
                    String gelen = convert.Convert_Decimal(input_Dec.getText().toString(), sValue);
                    dec_result.setText(gelen);
                }
                else{
                    dec_result.setText("Geçersiz Değer");
                }
            }
        });

        btn_Mega.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input_Mega.getText().toString().isEmpty()!=true){
                    sValue = spin_Mega.getSelectedItem().toString();
                    String gelen = convert.Convert_MegaByte(input_Mega.getText().toString(), sValue);
                    mega_Result.setText(gelen);
                }
                else{
                    mega_Result.setText("Geçersiz Değer");
                }
            }
        });

        btn_Cel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fah_Radio.isChecked()==true && input_Cel.getText().toString().isEmpty()!=true){
                    String gelen = convert.Convert_Celcius(input_Cel.getText().toString(),"Fahrenayt");
                    cel_Result.setText(gelen);
                }
                else if(kel_Radio.isChecked()==true && input_Cel.getText().toString().isEmpty()!=true){
                    String gelen = convert.Convert_Celcius(input_Cel.getText().toString(),"Kelvin");
                    cel_Result.setText(gelen);
                }
                else{
                    cel_Result.setText("Geçersiz Değer");
                }
            }
        });
    }

}