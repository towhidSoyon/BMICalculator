package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView bmiText,statusText, resultLineText;
    Button againCalcBtn;
    Animation topAnim,bottomAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        String bmi=getIntent().getExtras().getString("bmiResult");
        String weight=getIntent().getExtras().getString("weight");

        topAnim= AnimationUtils.loadAnimation(this,R.anim.top_anim);
        bottomAnim= AnimationUtils.loadAnimation(this,R.anim.down_anim);


        bmiText=findViewById(R.id.bmiTextId);
        statusText=findViewById(R.id.statusTextID);

        resultLineText=findViewById(R.id.resultText);
        againCalcBtn=findViewById(R.id.againCalcBtn);


        bmiText.setText(bmi);
        bmiText.setAnimation(topAnim);


        againCalcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ResultActivity.this,MainActivity.class);
                startActivity(intent);
                finish();

            }
        });





    }
}