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
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GyogyszerHozzaadasaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GyogyszerHozzaadasaFragment extends Fragment {
    private EditText editTextNev;
    private EditText editTextHatoanyagok;
    private EditText editTextKeszlet;
    private EditText editTextLink;
    private EditText editTextNapi;
    private CheckBox cbRendszeres;
    private RecyclerView rvAdagolas;
    private Button btnVissza;

    private Button btnMentes;

    private DBHelper adatbazis;

    public GyogyszerHozzaadasaFragment() {
        // Required empty public constructor
    }

    public static GyogyszerHozzaadasaFragment newInstance() {
        GyogyszerHozzaadasaFragment fragment = new GyogyszerHozzaadasaFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adatbazis = new DBHelper(getActivity());    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_gyogyszer_hozzaadasa, container, false);
        editTextNev = rootView.findViewById(R.id.editTextNev);
        editTextHatoanyagok = rootView.findViewById(R.id.editTextHatoanyag);
        editTextKeszlet = rootView.findViewById(R.id.editTextKeszlet);
        editTextLink = rootView.findViewById(R.id.editTextLink);
        cbRendszeres = rootView.findViewById(R.id.cbRendszeresSzedes);
        editTextNapi = rootView.findViewById(R.id.editTextNapi);
        btnVissza = rootView.findViewById(R.id.btnVissza);
        btnMentes = rootView.findViewById(R.id.btnMentes);

        // Inflate the layout for this fragment
        btnMentes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nev = editTextNev.getText().toString().trim();
                String hatoanyag = editTextHatoanyagok.getText().toString().trim();
                String keszletString = editTextKeszlet.getText().toString().trim();
                String link = editTextLink.getText().toString().trim();
                String napiString = editTextNapi.getText().toString().trim();
                int rendszeres = 0;
                if (cbRendszeres.isChecked()){
                    rendszeres = 1;
                }
                else {
                    rendszeres = 0;
                }
                if (nev.isEmpty() || hatoanyag.isEmpty() || keszletString.isEmpty() || link.isEmpty()) {
                    Toast.makeText(getActivity(), "Minden mező kitöltése kötelező", Toast.LENGTH_SHORT).show();
                }
                else {
                    try {
                        int keszlet = Integer.parseInt(keszletString);
                        int napi = Integer.parseInt(napiString);

                        if (adatbazis.gyogyszerHozzaadas(nev,hatoanyag,link,napi,keszlet,rendszeres)) {
                            Toast.makeText(getActivity(), "Gyógyszer hozzáadása sikeres", Toast.LENGTH_SHORT).show();
                            ((MainActivity) getActivity()).navigateToGyogyszereim();
                        }
                        else {
                            Toast.makeText(getActivity(), "Gyógyszer hozzáadása sikertelen "+keszlet, Toast.LENGTH_SHORT).show();
                        }
                    }
                    catch (NumberFormatException ex){
                        Toast.makeText(getActivity(), "A készletnek és a napi mennyiségnek számnak kell lennie", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnVissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "VISSZA", Toast.LENGTH_SHORT).show();
                ((MainActivity) getActivity()).navigateToGyogyszereim();
            }
        });

        return rootView;
    }
}