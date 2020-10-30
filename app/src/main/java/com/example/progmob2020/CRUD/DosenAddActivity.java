package com.example.progmob2020.CRUD;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
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

public class DosenAddActivity extends AppCompatActivity {
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosen_add);

        EditText edNama = (EditText)findViewById(R.id.editTextNamaDosen);
        EditText edNidn = (EditText)findViewById(R.id.editTextNidn);
        EditText edAlamat = (EditText)findViewById(R.id.editTextAlamatDosen);
        EditText edEmail = (EditText)findViewById(R.id.editTextEmailDosen);
        EditText edGelar = (EditText)findViewById(R.id.editTextGelar);
        Button btnSimpan = (Button)findViewById(R.id.buttonSimpanDsn);
        pd = new ProgressDialog(DosenAddActivity.this);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setTitle("Mohon Bersabar");
                pd.show();

                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = service.add_dsn(
                        edNama.getText().toString(),
                        edNidn.getText().toString(),
                        edAlamat.getText().toString(),
                        edEmail.getText().toString(),
                        edGelar.getText().toString(),
                        "Apa Jha",
                        "72180195"
                );

                call.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(DosenAddActivity.this, "Data Berhasil Disimpan", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(DosenAddActivity.this, "Data Gagal Disimpan", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}