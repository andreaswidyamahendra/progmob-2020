package com.example.progmob2020.CRUD;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.progmob2020.R;

public class MainDsnActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dsn);

        Button btna = (Button)findViewById(R.id.buttonGetDsn);
        Button btnb = (Button)findViewById(R.id.buttonAddDsn);
        Button btnc = (Button)findViewById(R.id.buttonUpdateDsn);
        Button btnd = (Button)findViewById(R.id.buttonHapusDsn);

        btna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainDsnActivity.this, DosenGetAllActivity.class);
                startActivity(intent);
            }
        });

        btnb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainDsnActivity.this, DosenAddActivity.class);
                startActivity(intent);
            }
        });

        btnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainDsnActivity.this, DosenUpdateActivity.class);
                startActivity(intent);
            }
        });

        btnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainDsnActivity.this, DosenDeleteActivity.class);
                startActivity(intent);
            }
        });
    }
}