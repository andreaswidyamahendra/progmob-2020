package com.example.progmob2020.CRUD;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.progmob2020.R;

public class MainMatkulActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_matkul);

        Button a = (Button)findViewById(R.id.buttonGetMatkul);
        Button b = (Button)findViewById(R.id.buttonAddMatkul);
        Button c = (Button)findViewById(R.id.buttonUpdateMatkul);
        Button e = (Button)findViewById(R.id.buttonHapusMatkul);

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMatkulActivity.this, MatakuliahGetAllActivity.class);
                startActivity(intent);
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMatkulActivity.this, MatakuliahAddActivity.class);
                startActivity(intent);
            }
        });

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMatkulActivity.this, MatakuliahUpdateActivity.class);
                startActivity(intent);
            }
        });

        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMatkulActivity.this, MatakuliahDeleteActivity.class);
                startActivity(intent);
            }
        });
    }
}