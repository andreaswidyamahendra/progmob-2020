package com.example.progmob2020.CRUD;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.progmob2020.R;

public class MainMhsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mhs);

        Button btnLihatMhs = (Button)findViewById(R.id.buttonGetMhs);
        Button btnTambahMhs = (Button)findViewById(R.id.buttonAddMhs);
        Button btnUpdateMhs = (Button)findViewById(R.id.buttonUpdate);
        Button btnHapusMhs = (Button)findViewById(R.id.buttonHapus);

        btnLihatMhs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMhsActivity.this, MahasiswaGetAllActivity.class);
                startActivity(intent);
            }
        });

        btnTambahMhs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMhsActivity.this, MahasiswaAddActivity.class);
                startActivity(intent);
            }
        });

        btnUpdateMhs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMhsActivity.this, MahasiswaUpdateActivity.class);
                startActivity(intent);
            }
        });

        btnHapusMhs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMhsActivity.this, MahasiswaDeleteActivity.class);
                startActivity(intent);
            }
        });
    }
}