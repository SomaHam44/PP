package com.example.pp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Lista_Adapter extends RecyclerView.Adapter<Lista_Adapter.GyogyszerHolder> {
    private List<Gyogyszer> gyogyszeresLista;
    private GyogyszereimFragment gyogyszereimFragment;

    public Lista_Adapter(GyogyszereimFragment gyogyszereimFragment, List<Gyogyszer> moviesList) {
        this.gyogyszereimFragment = gyogyszereimFragment;
        this.gyogyszeresLista = gyogyszeresLista;
    }
    @Override
    public GyogyszerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_sor, parent, false);
        return new GyogyszerHolder(itemView);
    }
    public void onBindViewHolder(GyogyszerHolder holder, int position) {
        final Gyogyszer gyogyszer = gyogyszeresLista.get(position);
        holder.IDTextView.setText(gyogyszer.getId());
        holder.gyogyszerNevTextView.setText(gyogyszer.getNev());
        holder.keszletTextView.setText(gyogyszer.getKeszlet());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                gyogyszereimFragment.selectItemAndNavigate(gyogyszer);
            }
        });
    }
    public int getItemCount() {
        return gyogyszeresLista.size();
    }
    public class GyogyszerHolder extends RecyclerView.ViewHolder {
        public TextView IDTextView;
        public TextView gyogyszerNevTextView;
        public TextView keszletTextView;
        public GyogyszerHolder(View itemView) { super(itemView);
            IDTextView = itemView.findViewById(R.id.IDTextView);
            gyogyszerNevTextView = itemView.findViewById(R.id.gyogyszerNevTextView);
            keszletTextView = itemView.findViewById(R.id.keszletTextView); } }

}
