package com.example.progmob2020.CRUD;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.progmob2020.Model.DefaultResult;
import com.example.progmob2020.Network.GetDataService;
import com.example.progmob2020.Network.RetrofitClientInstance;
import com.example.progmob2020.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MahasiswaUpdateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa_update);

        EditText edNimCari = (EditText)findViewById(R.id.editTextNimCari);
        EditText edNamaBaru = (EditText)findViewById(R.id.editTextNamaBaru);
        EditText edNimBaru = (EditText)findViewById(R.id.editTextNimBaru);
        EditText edAlamatBaru = (EditText)findViewById(R.id.editTextAlamatBaru);
        EditText edEmailBaru = (EditText)findViewById(R.id.editTextEmailBaru);
        Button buttonUpdate = (Button)findViewById(R.id.buttonUbah);

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = service.update_mhs(
                        edNimCari.getText().toString(),
                        edNamaBaru.getText().toString(),
                        edNimBaru.getText().toString(),
                        edAlamatBaru.getText().toString(),
                        edEmailBaru.getText().toString(),
                        "Apa Jha",
                        "72180195"
                );


                call.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        Toast.makeText(MahasiswaUpdateActivity.this, "Data Berhasil Diupdate", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        Toast.makeText(MahasiswaUpdateActivity.this, "Data Gagal Diupdate", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}