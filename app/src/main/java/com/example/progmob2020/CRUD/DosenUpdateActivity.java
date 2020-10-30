package com.example.progmob2020.CRUD;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.progmob2020.Model.DefaultResult;
import com.example.progmob2020.Network.GetDataService;
import com.example.progmob2020.Network.RetrofitClientInstance;
import com.example.progmob2020.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DosenUpdateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosen_update);

        EditText edNidnCari = (EditText)findViewById(R.id.editTextNidnCari);
        EditText edNamaBaru = (EditText)findViewById(R.id.editTextNamaBaruDosen);
        EditText edNidnBaru = (EditText)findViewById(R.id.editTextNidnBaru);
        EditText edAlamatBaru = (EditText)findViewById(R.id.editTextAlamatBaruDosen);
        EditText edEmailBaru = (EditText)findViewById(R.id.editTextEmailBaruDosen);
        EditText edGelarBaru = (EditText)findViewById(R.id.editTextGelarBaru);
        Button btnUbah = (Button)findViewById(R.id.buttonUbahDosen);

        btnUbah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = service.update_dsn(
                        edNamaBaru.getText().toString(),
                        edNidnBaru.getText().toString(),
                        edAlamatBaru.getText().toString(),
                        edEmailBaru.getText().toString(),
                        edGelarBaru.getText().toString(),
                        "Apa Jha",
                        "72180195",
                        edNidnCari.getText().toString()
                );
                call.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        Toast.makeText(DosenUpdateActivity.this, "Data Berhasil Diupdate", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        Toast.makeText(DosenUpdateActivity.this, "Data Gagal Diupdate", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}