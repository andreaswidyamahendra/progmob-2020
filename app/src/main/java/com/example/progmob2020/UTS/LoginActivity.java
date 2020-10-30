package com.example.progmob2020.UTS;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.progmob2020.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button a = (Button)findViewById(R.id.buttonLogin);
        final EditText t = (EditText)findViewById(R.id.editTextUserName);
        final EditText pw = (EditText)findViewById(R.id.editTextPassword);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                Bundle b = new Bundle();
                b.putString("help_string", t.getText().toString());
                intent.putExtras(b);
                if (t.getText().toString().length()==0){
                    t.setError("Masukan Username");
                }else if
                (pw.getText().toString().length()==0){
                    pw.setError("Masukan Password");
                }else{
                    Toast.makeText(getApplicationContext(), "Berhasil Login" , Toast.LENGTH_LONG).show();
                    startActivity(intent);
                }
            }
        });
    }
}