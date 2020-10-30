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

public class MatakuliahUpdateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matakuliah_update);

        EditText edKodeCari = (EditText)findViewById(R.id.editTextKodeCari);
        EditText edNamaBaru = (EditText)findViewById(R.id.editTextNamaMatkulBaru);
        EditText edKodeBaru = (EditText)findViewById(R.id.editTextKodeMatkulBaru);
        EditText edHariBaru = (EditText)findViewById(R.id.editTextHariBaru);
        EditText edSesiBaru = (EditText)findViewById(R.id.editTextSesiBaru);
        EditText edSksBaru = (EditText)findViewById(R.id.editTextSksBaru);
        Button buttonUpdate = (Button)findViewById(R.id.buttonUbahMatkul);

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = service.update_matkul(
                        edNamaBaru.getText().toString(),
                        "72180195",
                        edKodeBaru.getText().toString(),
                        edHariBaru.getText().toString(),
                        edSesiBaru.getText().toString(),
                        edSksBaru.getText().toString(),
                        edKodeCari.getText().toString()

                );

                call.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        Toast.makeText(MatakuliahUpdateActivity.this, "Data Berhasil Diupdate", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        Toast.makeText(MatakuliahUpdateActivity.this, "Data Gagal Diupdate", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}