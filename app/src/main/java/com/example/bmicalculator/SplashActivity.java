package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    Animation topAnim,bottomAnim;

    private ImageView imageView;
    private TextView nameText,bottomText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        topAnim= AnimationUtils.loadAnimation(this,R.anim.top_anim);
        bottomAnim= AnimationUtils.loadAnimation(this,R.anim.down_anim);

        imageView=findViewById(R.id.imageView2);
        nameText=findViewById(R.id.nameText);
        bottomText=findViewById(R.id.bottomText);

        imageView.setAnimation(topAnim);
        nameText.setAnimation(bottomAnim);
        bottomText.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },4000);

    }
}