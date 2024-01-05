package com.example.pp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GyogyszerBevetelFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GyogyszerBevetelFragment extends Fragment {
    private TextView gyogyszerNev;
    private EditText darab;
    private Button btnMentes;
    private Button btnVissza;
    private DBHelper adatbazis;

    public GyogyszerBevetelFragment() {
        // Required empty public constructor
    }
    public static GyogyszerBevetelFragment newInstance() {
        GyogyszerBevetelFragment fragment = new GyogyszerBevetelFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adatbazis = new DBHelper(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_gyogyszer_bevetel, container, false);
        gyogyszerNev=rootView.findViewById(R.id.CimText);
        darab=rootView.findViewById(R.id.editTextNumber);
        btnVissza = rootView.findViewById(R.id.btnVissza);
        btnMentes = rootView.findViewById(R.id.btnTovabb);
        Gyogyszer gyogyszer = ((MainActivity) getActivity()).getSelectedGyogyszer();
        int aktualisKeszlet=gyogyszer.getKeszlet();
        gyogyszerNev.setText(gyogyszer.getNev());

        btnMentes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String csokkString = darab.getText().toString().trim();
                try{
                    int csokk = Integer.parseInt(csokkString);
                    int ujKeszlet = aktualisKeszlet-csokk;
                    adatbazis.keszletModositas(gyogyszer.getId(),ujKeszlet);
                }
                catch (NumberFormatException ex){
                    Toast.makeText(getActivity(), "A készletnek számnak kell lennie", Toast.LENGTH_SHORT).show();
                }
                ((MainActivity) getActivity()).navigateToGyogyszereim();
            }
        });



        btnVissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Vissza", Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }

}