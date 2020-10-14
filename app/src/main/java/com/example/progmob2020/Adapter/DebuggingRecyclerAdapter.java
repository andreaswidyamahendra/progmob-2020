package com.example.progmob2020.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.progmob2020.Model.MahasiswaDebugging;
import com.example.progmob2020.R;

import java.util.ArrayList;
import java.util.List;

public class DebuggingRecyclerAdapter extends RecyclerView.Adapter<DebuggingRecyclerAdapter.ViewHolder> {
    private Context context;
    private List<MahasiswaDebugging> mahasiswaListDebug;

    public DebuggingRecyclerAdapter(Context context) {
        this.context = context;
        mahasiswaListDebug = new ArrayList<>();
    }

    public List<MahasiswaDebugging> getMahasiswaList() {
        return mahasiswaListDebug;
    }

    public void setMahasiswaList(List<MahasiswaDebugging> mahasiswaListDebug) {
        this.mahasiswaListDebug = mahasiswaListDebug;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_list_cardview,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MahasiswaDebugging m = mahasiswaListDebug.get(position);
        //Mahasiswa m = mahasiswaList.get(position);

        holder.tvNama.setText(m.getNama());
        holder.txtNoTelp.setText(m.getNotelp());
        holder.tvNim.setText(m.getNim());
    }

    @Override
    public int getItemCount() {
        return mahasiswaListDebug.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvNama, tvNim, txtNoTelp;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvNim = itemView.findViewById(R.id.tvNim);
            txtNoTelp = itemView.findViewById(R.id.txtNoTelp);
        }
    }
}
