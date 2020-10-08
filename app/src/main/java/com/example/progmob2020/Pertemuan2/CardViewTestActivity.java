package com.example.progmob2020.Pertemuan2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.progmob2020.Adapter.MahasiswaRecyclerAdapter;
import com.example.progmob2020.Model.Mahasiswa;
import com.example.progmob2020.R;

import java.util.ArrayList;
import java.util.List;

public class CardViewTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardviewtestactivity);

        //CardView cv = (CardView)findViewById(R.id.cvMahasiswa);
        RecyclerView rv = (RecyclerView)findViewById(R.id.rvLatihan);
        MahasiswaRecyclerAdapter mahasiswaRecyclerAdapter;

        //Data
        List<Mahasiswa> mahasiswaList = new ArrayList<Mahasiswa>();

        //generate
        Mahasiswa m1 = new Mahasiswa("Andreas", "72180195", "0123");
        Mahasiswa m2 = new Mahasiswa("Widya", "72180196", "0124");
        Mahasiswa m3 = new Mahasiswa("Mahendra", "72180197", "0125");
        Mahasiswa m4 = new Mahasiswa("Budi", "72180198", "0126");
        Mahasiswa m5 = new Mahasiswa("Bambang", "72180199", "0127");

        mahasiswaList.add(m1);
        mahasiswaList.add(m2);
        mahasiswaList.add(m3);
        mahasiswaList.add(m4);
        mahasiswaList.add(m5);

        mahasiswaRecyclerAdapter = new MahasiswaRecyclerAdapter(CardViewTestActivity.this);
        mahasiswaRecyclerAdapter.setMahasiswaList(mahasiswaList);

        //cv.setLayoutManager

        rv.setLayoutManager(new LinearLayoutManager(CardViewTestActivity.this));
        rv.setAdapter(mahasiswaRecyclerAdapter);
    }
}