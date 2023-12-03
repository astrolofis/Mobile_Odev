package com.example.mobileodev;

import static android.view.Gravity.CENTER;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;

public class random_Activity extends AppCompatActivity {

    EditText input_Adet,input_maks,input_min;
    Button btn_Progress;

    LinearLayout linear_lay;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);
        input_Adet=findViewById(R.id.input_Adet);
        input_maks=findViewById(R.id.input_maks);
        input_min=findViewById(R.id.input_min);
        btn_Progress=findViewById(R.id.btn_Progress);

        linear_lay=findViewById(R.id.linear_lay);


        btn_Progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input_Adet.getText().toString().isEmpty()!=true&&
                   input_maks.getText().toString().isEmpty()!=true&&
                   input_min.getText().toString().isEmpty()!=true){
                    int adet= Integer.parseInt(input_Adet.getText().toString());
                    int maks= Integer.parseInt(input_maks.getText().toString());
                    int min= Integer.parseInt(input_min.getText().toString());
                    generate_Progress(adet,maks,min);
                }
            }
        });
    }

    public void generate_Progress(int adet, int maks, int min){
        Random random=new Random();
        for(int i=0;i<adet;i++){
            TextView textMin=new TextView(this);
            TextView textMax=new TextView(this);
            TextView textDeger=new TextView(this);

            int maxi=0,mini=0,deger=0;

            for(int j=0;j<1;j++) {
                int random1 = random.nextInt(maks - min + 1) + min;
                int random2 = random.nextInt(maks - min + 1) + min;
                if(random1 !=random2){
                    j=0;
                }
                int [] dizi={random1,random2};
                Arrays.sort(dizi);
                int random3= random.nextInt(dizi[1]-dizi[0]+1)+dizi[0];

                maxi=dizi[1];
                mini=dizi[0];
                deger=random3;

            }
            textMin.setText(String.valueOf(mini));
            textMax.setText(String.valueOf(maxi));

            int yuzde=(((deger-mini)*100)/(maxi-mini));

            textDeger.setText(String.valueOf(deger)+"="+yuzde+"%");

            LinearLayout linear_lay_Hor=new LinearLayout(this);

            LinearLayout.LayoutParams linearParams= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);

            linearParams.setMargins(0,0,250,0);

            textMin.setLayoutParams(linearParams);
            textDeger.setLayoutParams(linearParams);


            linear_lay_Hor.addView(textMin);
            linear_lay_Hor.addView(textDeger);
            linear_lay_Hor.addView(textMax);
            linear_lay.addView((linear_lay_Hor));

            ProgressBar progress_Bar=new ProgressBar(this,null,android.R.attr.progressBarStyleHorizontal);

            progress_Bar.setMax(maxi);
            progress_Bar.setMin(mini);
            progress_Bar.setProgress(deger);

            linear_lay.addView(progress_Bar);


        }
    }

}