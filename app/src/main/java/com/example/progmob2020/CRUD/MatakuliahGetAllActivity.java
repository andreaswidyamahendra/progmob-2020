package com.example.progmob2020.CRUD;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.progmob2020.Adapter.MahasiswaCRUDRecyclerAdapter;
import com.example.progmob2020.Adapter.MataKuliahCRUDRecyclerAdapter;
import com.example.progmob2020.Model.Mahasiswa;
import com.example.progmob2020.Model.MataKuliah;
import com.example.progmob2020.Network.GetDataService;
import com.example.progmob2020.Network.RetrofitClientInstance;
import com.example.progmob2020.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MatakuliahGetAllActivity extends AppCompatActivity {

    RecyclerView rvMatkul;
    MataKuliahCRUDRecyclerAdapter matkulAdapter;
    ProgressDialog pd;
    List<MataKuliah> matakuliahList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matakuliah_get_all);

        rvMatkul = (RecyclerView)findViewById(R.id.rvGetMatkulAll);
        pd = new ProgressDialog(this);
        pd.setTitle("Mohon Bersabar");
        pd.show();

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<MataKuliah>> call = service.getmatkul("72180195");

        call.enqueue(new Callback<List<MataKuliah>>() {
            @Override
            public void onResponse(Call<List<MataKuliah>> call, Response<List<MataKuliah>> response) {
                pd.dismiss();
                matakuliahList = response.body();
                matkulAdapter = new MataKuliahCRUDRecyclerAdapter(matakuliahList);


                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MatakuliahGetAllActivity.this);
                rvMatkul.setLayoutManager(layoutManager);
                rvMatkul.setAdapter(matkulAdapter);
            }

            @Override
            public void onFailure(Call<List<MataKuliah>> call, Throwable t) {
                pd.dismiss();
                Toast.makeText(MatakuliahGetAllActivity.this, "Error", Toast.LENGTH_LONG).show();
            }
        });
    }
}