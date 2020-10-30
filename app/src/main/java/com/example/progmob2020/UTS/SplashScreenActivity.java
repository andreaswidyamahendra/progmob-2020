package com.example.progmob2020.UTS;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.progmob2020.R;

public class SplashScreenActivity extends AppCompatActivity {
    private int waktu_loading=4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //setelah loading maka akan langsung berpindah ke Login activity
                Intent home=new Intent(SplashScreenActivity.this, LoginActivity.class);
                startActivity(home);
                finish();
            }
        },waktu_loading);
    }
}