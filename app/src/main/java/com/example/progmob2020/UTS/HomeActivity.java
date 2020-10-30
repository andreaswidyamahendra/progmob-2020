package com.example.progmob2020.UTS;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.progmob2020.CRUD.DosenAddActivity;
import com.example.progmob2020.CRUD.DosenGetAllActivity;
import com.example.progmob2020.CRUD.MainDsnActivity;
import com.example.progmob2020.CRUD.MainMatkulActivity;
import com.example.progmob2020.CRUD.MainMhsActivity;
import com.example.progmob2020.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView tampil = (TextView)findViewById(R.id.textViewWelcome);
        ImageButton a = (ImageButton) findViewById(R.id.imageButtonLogout);
        ImageButton c = (ImageButton) findViewById(R.id.imageButtonDsn);
        ImageButton d = (ImageButton) findViewById(R.id.imageButtonMhs);
        ImageButton e = (ImageButton) findViewById(R.id.imageButtonMatkul);

        Bundle b = getIntent().getExtras();
        String textHelp = b.getString("help_string");
        tampil.setText(textHelp);

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(intent);
                /*new AlertDialog.Builder(getApplication())
                        .setTitle("Apakah Kamu Ingin Keluar?")
                        .setMessage("Ingin Keluar Dari Aplikasi Ini?")
                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "Anda Telah Logout", Toast.LENGTH_LONG).show();
                                //Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                                //startActivity(intent);
                            }
                        })
                        .setNegativeButton("TIDAK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplication(), "Anda Tidak Jadi Keluar", Toast.LENGTH_LONG).show();
                            dialog.cancel();
                    }
                }).show();*/

            }
        });

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MainDsnActivity.class);
                startActivity(intent);
            }
        });

        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MainMhsActivity.class);
                startActivity(intent);
            }
        });

        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MainMatkulActivity.class);
                startActivity(intent);
            }
        });
    }
}