package com.example.pp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VasarlasRogziteseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VasarlasRogziteseFragment extends Fragment {
    private TextView gyogyszerNev;
    private EditText darab;
    private Button  btnMentes, btnVissza;
    private DBHelper adatbazis;
    public VasarlasRogziteseFragment() {
        // Required empty public constructor
    }
    public static VasarlasRogziteseFragment newInstance() {
        VasarlasRogziteseFragment fragment = new VasarlasRogziteseFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_vasarlas_rogzitese, container, false);
        gyogyszerNev = rootView.findViewById(R.id.cimText);
        darab = rootView.findViewById(R.id.editTextNumber);
        btnMentes = rootView.findViewById(R.id.btnTovabb);
        btnVissza = rootView.findViewById(R.id.btnVissza);
        Gyogyszer gyogyszer = ((MainActivity) getActivity()).getSelectedGyogyszer();
        int aktualisKeszlet = gyogyszer.getKeszlet();
        gyogyszerNev.setText(gyogyszer.getNev());

        btnMentes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String novString = darab.getText().toString().trim();
                try{
                    int nov = Integer.parseInt(novString);
                    int ujKeszlet = aktualisKeszlet+nov;
                    if(adatbazis.keszletModositas(gyogyszer.getId(),ujKeszlet)){
                        Toast.makeText(getActivity(), "A készlet módosítása sikeres", Toast.LENGTH_SHORT).show();
                        ((MainActivity) getActivity()).navigateToGyogyszereim();
                    }
                    else{
                        Toast.makeText(getActivity(), "A készlet módosítása sikertelen", Toast.LENGTH_SHORT).show();
                    };
                }
                catch (NumberFormatException ex){
                    Toast.makeText(getActivity(), "A készletnek számnak kell lennie", Toast.LENGTH_SHORT).show();
                }
            }
        });



        btnVissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).navigateToDetails(gyogyszer);
            }
        });

        // Inflate the layout for this fragment
        return rootView;
    }
}