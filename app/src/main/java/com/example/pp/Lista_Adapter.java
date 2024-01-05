package com.example.pp;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Lista_Adapter extends RecyclerView.Adapter<Lista_Adapter.GyogyszerHolder> {
    private List<Gyogyszer> gyogyszeresLista;

    private GyogyszereimFragment gyogyszereimFragment;

    public Lista_Adapter(GyogyszereimFragment gyogyszereimFragment, List<Gyogyszer> gyogyszeresLista) {
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
        int napok = gyogyszer.getKeszlet()/gyogyszer.getNapi();
        if(napok<3){
            holder.IDTextView.setTextColor(Color.RED);
            holder.gyogyszerNevTextView.setTextColor(Color.RED);
            holder.keszletTextView.setTextColor(Color.RED);
        }
        holder.IDTextView.setText(gyogyszer.getStringId());
        holder.gyogyszerNevTextView.setText(gyogyszer.getNev());
        holder.keszletTextView.setText(gyogyszer.getStringKeszlet());

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
