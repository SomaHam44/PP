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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GyogyszerReszletekFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GyogyszerReszletekFragment extends Fragment {
    private EditText editTextNev;
    private EditText editTextHatoanyag;
    private EditText editTextLink;
    private TextView TextViewSelectedID;
    private EditText editTextNapi;
    private EditText editTextKeszlet;
    private CheckBox cbRendszeres;
    private Button btnVissza, btnMentes, btnTorles, btnNov, btnCsokk;
    private DBHelper adatbazis;

    private TextView napszam;
    private int napok;
    private TextView idopont;

    public GyogyszerReszletekFragment() {
        // Required empty public constructor
    }
    public static GyogyszerReszletekFragment newInstance() {
        GyogyszerReszletekFragment fragment = new GyogyszerReszletekFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_gyogyszer_reszletek, container, false);
        editTextNev = rootView.findViewById(R.id.editTextNev);
        editTextHatoanyag = rootView.findViewById(R.id.editTextHatoanyag);
        editTextLink = rootView.findViewById(R.id.editTextLink);
        editTextKeszlet = rootView.findViewById(R.id.editTextKeszlet);
        editTextNapi = rootView.findViewById(R.id.editTextNapi);
        TextViewSelectedID = rootView.findViewById(R.id.TextViewSelectedID);
        cbRendszeres = rootView.findViewById(R.id.cbRendszeresSzedes);
        btnMentes = rootView.findViewById(R.id.btnTovabb);
        btnVissza = rootView.findViewById(R.id.btnVissza);
        btnTorles = rootView.findViewById(R.id.btnTorles);
        btnNov=rootView.findViewById(R.id.btnNov);
        btnCsokk=rootView.findViewById(R.id.btnCsokk);
        napszam = rootView.findViewById(R.id.napszam);
        idopont = rootView.findViewById(R.id.idopont);

        Gyogyszer gyogyszer = ((MainActivity) getActivity()).getSelectedGyogyszer();
        TextViewSelectedID.setText(gyogyszer.getStringId());
        editTextNev.append(gyogyszer.getNev());
        editTextHatoanyag.append(gyogyszer.getHatoanyag());
        editTextLink.append(gyogyszer.getLink());
        editTextNapi.append(gyogyszer.getStringNapi());
        editTextKeszlet.append(gyogyszer.getStringKeszlet());
        napszam.append(String.valueOf(gyogyszer.getKeszlet()/gyogyszer.getNapi()));
        //idopont.append(gyogyszer.getMod());
        //int utolsoKeszlet = gyogyszer.getKeszlet();
        //String utolsoMod = gyogyszer.getMod();

        btnMentes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nev = editTextNev.getText().toString().trim();
                String hatoanyag = editTextHatoanyag.getText().toString().trim();
                String keszletString = editTextKeszlet.getText().toString().trim();
                String link = editTextLink.getText().toString().trim();
                String napiString = editTextNapi.getText().toString().trim();
                try {
                    int keszlet = Integer.parseInt(keszletString);
                    int napi = Integer.parseInt(napiString);
                    if (adatbazis.gyogyszerModositas(gyogyszer.getId(), nev, hatoanyag, link, napi, keszlet)) {
                        Toast.makeText(getActivity(), "Gyógyszer módosítása sikeres", Toast.LENGTH_SHORT).show();
                        ((MainActivity) getActivity()).navigateToGyogyszereim();
                    } else {
                        Toast.makeText(getActivity(), "Gógyszer módosítása sikertelen " + keszlet, Toast.LENGTH_SHORT).show();
                    }
                }
                catch (NumberFormatException ex){
                    Toast.makeText(getActivity(), "A készletnek és a napi mennyiségnek számnak kell lennie", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnTorles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adatbazis.torles(gyogyszer.getId());
                ((MainActivity) getActivity()).navigateToGyogyszereim();
            }
        });

        btnVissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).navigateToGyogyszereim();
            }
        });

        btnCsokk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).navigateToGyogyszerBevetel(gyogyszer);
            }
        });

        btnNov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).navigateToGyogyszerVasarlas(gyogyszer);
            }
        });
        return rootView;
    }

}