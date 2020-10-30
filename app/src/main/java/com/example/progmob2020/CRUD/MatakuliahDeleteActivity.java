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

public class MatakuliahDeleteActivity extends AppCompatActivity {
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matakuliah_delete);

        EditText edKode = (EditText)findViewById(R.id.editTextKodeHapus);
        Button btnHapus = (Button)findViewById(R.id.buttonHapusMatkul1);
        pd = new ProgressDialog(MatakuliahDeleteActivity.this);

        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = service.delete_matkul(
                        edKode.getText().toString(),
                        "72180195"
                );

                call.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(MatakuliahDeleteActivity.this, "Data Berhasil Dihapus", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(MatakuliahDeleteActivity.this, "Data Gagal Dihapus", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}