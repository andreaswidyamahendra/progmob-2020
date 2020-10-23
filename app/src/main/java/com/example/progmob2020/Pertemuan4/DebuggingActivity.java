package com.example.progmob2020.Pertemuan4;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import android.os.Bundle;

        import java.util.ArrayList;
        import java.util.List;

        import com.example.progmob2020.Adapter.DebuggingRecyclerAdapter;
        import com.example.progmob2020.Adapter.MahasiswaRecyclerAdapter;
        import com.example.progmob2020.Model.Mahasiswa;
        import com.example.progmob2020.Model.MahasiswaDebugging;
        import com.example.progmob2020.Pertemuan2.RecyclerActivity;
        import com.example.progmob2020.R;

public class DebuggingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debugging);

        RecyclerView rv = (RecyclerView)findViewById(R.id.rvLatihan);
        DebuggingRecyclerAdapter debuggingRecyclerAdapter;
        //MahasiswaRecyclerAdapter mahasiswaRecyclerAdapter;

        //data dummy
        List<MahasiswaDebugging> mahasiswaList = new ArrayList<MahasiswaDebugging>();
        //List<Mahasiswa> mahasiswaList = new ArrayList<Mahasiswa>();

        //generate data mahasiswa
        MahasiswaDebugging m1 = new MahasiswaDebugging("Argo","72110101","084646464646");
        MahasiswaDebugging m2 = new MahasiswaDebugging("Halim","72110101","084646464646");
        MahasiswaDebugging m3 = new MahasiswaDebugging("Jong Jek Siang","72110101","084646464646");
        MahasiswaDebugging m4 = new MahasiswaDebugging("Katon","72110101","084646464646");
        MahasiswaDebugging m5 = new MahasiswaDebugging("Yetli","72110101","084646464646");
        /*Mahasiswa m1 = new Mahasiswa("Argo","72110101","084646464646");
        Mahasiswa m2 = new Mahasiswa("Halim","72110101","084646464646");
        Mahasiswa m3 = new Mahasiswa("Jong Jek Siang","72110101","084646464646");
        Mahasiswa m4 = new Mahasiswa("Katon","72110101","084646464646");
        Mahasiswa m5 = new Mahasiswa("Yetli","72110101","084646464646");*/

        mahasiswaList.add(m1);
        mahasiswaList.add(m2);
        mahasiswaList.add(m3);
        mahasiswaList.add(m4);
        mahasiswaList.add(m5);

        //List<Mahasiswa> mahasiswaListDebug = new ArrayList<Mahasiswa>();

        //mahasiswaRecyclerAdapter = new MahasiswaRecyclerAdapter(DebuggingActivity.this);
        //mahasiswaRecyclerAdapter.setMahasiswaList(mahasiswaListDebug);

        debuggingRecyclerAdapter = new DebuggingRecyclerAdapter(DebuggingActivity.this);
        debuggingRecyclerAdapter.setMahasiswaList(mahasiswaList);

        rv.setLayoutManager(new LinearLayoutManager(DebuggingActivity.this));
        rv.setAdapter(debuggingRecyclerAdapter);
        //rv.setAdapter(mahasiswaRecyclerAdapter);
    }
}