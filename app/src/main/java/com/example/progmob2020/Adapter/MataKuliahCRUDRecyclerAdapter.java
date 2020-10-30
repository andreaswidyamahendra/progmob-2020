package com.example.progmob2020.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.progmob2020.Model.MataKuliah;
import com.example.progmob2020.R;

import java.util.ArrayList;
import java.util.List;

public class MataKuliahCRUDRecyclerAdapter extends RecyclerView.Adapter<MataKuliahCRUDRecyclerAdapter.ViewHolder> {
    private Context context;
    private List<MataKuliah> matakuliahList;

    public MataKuliahCRUDRecyclerAdapter(Context context) {
        this.context = context;
        matakuliahList = new ArrayList<>();
    }

    public MataKuliahCRUDRecyclerAdapter(List<MataKuliah> matakuliahList) {
        this.matakuliahList = matakuliahList;
    }

    public List<MataKuliah> getMataKuliahList() {
        return matakuliahList;
    }

    public void setMataKuliahList(List<MataKuliah> matakuliahList) {
        this.matakuliahList = matakuliahList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_dosen_list,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MataKuliah mk = matakuliahList.get(position);

        holder.tvNama.setText(mk.getNama());
        holder.tvKode.setText(mk.getKode());
        holder.tvHari.setText(mk.getHari());
        holder.tvSesi.setText(mk.getSesi());
        holder.tvSks.setText((mk.getSks()));
    }

    @Override
    public int getItemCount() {
        return matakuliahList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvKode, tvNama, tvHari, tvSesi, tvSks;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNamaMatkul);
            tvKode = itemView.findViewById(R.id.tvKode);
            tvHari = itemView.findViewById(R.id.tvHari);
            tvSesi = itemView.findViewById(R.id.tvSesi);
            tvSks = itemView.findViewById(R.id.tvSks);
        }
    }
}
