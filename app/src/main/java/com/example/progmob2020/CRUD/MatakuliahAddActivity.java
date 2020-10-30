package com.example.progmob2020.CRUD;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.progmob2020.Model.DefaultResult;
import com.example.progmob2020.Model.MataKuliah;
import com.example.progmob2020.Network.GetDataService;
import com.example.progmob2020.Network.RetrofitClientInstance;
import com.example.progmob2020.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MatakuliahAddActivity extends AppCompatActivity {
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matakuliah_add);

        EditText edNamaMatkul = (EditText)findViewById(R.id.editTextNamaMatakuliahTambah);
        EditText edKode = (EditText)findViewById(R.id.editTextKodeTambah);
        EditText edHari = (EditText)findViewById(R.id.editTextHariTambah);
        EditText edSesi = (EditText)findViewById(R.id.editTextSesiTambah);
        EditText edSks = (EditText)findViewById(R.id.editTextSksTambah);
        Button btnSimpan = (Button)findViewById(R.id.buttonSimpanMatkul);
        pd = new ProgressDialog(MatakuliahAddActivity.this);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setTitle("Mohon Bersabar");
                pd.show();

                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = service.add_matkul(
                        edNamaMatkul.getText().toString(),
                        "72180195",
                        edKode.getText().toString(),
                        edHari.getText().toString(),
                        edSesi.getText().toString(),
                        edSks.getText().toString()
                );

                call.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(MatakuliahAddActivity.this, "Data Berhasil Disimpan", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(MatakuliahAddActivity.this, "Data Gagal Disimpan", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}