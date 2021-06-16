package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity{

    private ImageButton maleImgBtn,femaleImgBtn;
    private AppCompatButton calcBtn;
    private EditText weightText, ftText, inchText;
    private TextView head;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        maleImgBtn = findViewById(R.id.maleImgBtn);
        femaleImgBtn = findViewById(R.id.femaleImgBtn);
        calcBtn = findViewById(R.id.calcButton);
        weightText = findViewById(R.id.weightText);
        ftText = findViewById(R.id.ftText);
        inchText = findViewById(R.id.inchText);

        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int weightInt;
                int heightFtInt;
                int heightInchInt;

                String weight = weightText.getText().toString();
                String heightFt = ftText.getText().toString();
                String heightInch = inchText.getText().toString();
                if (TextUtils.isEmpty(weight) || TextUtils.isEmpty(heightFt) || TextUtils.isEmpty(heightInch)) {
                    return;
                } else {
                    weightInt = Integer.parseInt(weightText.getText().toString());
                    heightFtInt = Integer.parseInt(ftText.getText().toString());
                    heightInchInt = Integer.parseInt(inchText.getText().toString());
                }


                int totalHeight = (heightFtInt * 12) + heightInchInt;

                double heightInMeter = totalHeight * 0.0254;

                int finalWeight = weightInt;
                calcBMI(finalWeight, heightInMeter);


            }
        });

        maleImgBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                maleImgBtn.setBackgroundColor(R.color.design_default_color_error);
            }
        });

        femaleImgBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                femaleImgBtn.setBackgroundColor(R.color.design_default_color_error);
            }
        });

    }


    private void calcBMI(int weight, double height) {
        double result= weight/ (height*height);
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        Intent intent=new Intent(MainActivity.this,ResultActivity.class);
        intent.putExtra("bmiResult",df.format(result));
        intent.putExtra("weight",weight);
        startActivity(intent);
        finish();
    }


}