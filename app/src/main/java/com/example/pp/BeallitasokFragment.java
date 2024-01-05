package com.example.pp;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
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
 * Use the {@link BeallitasokFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BeallitasokFragment extends Fragment {
    private EditText editTextNev;
    private EditText editSzulDatum;
    private DatePicker dpSzulDatum;
    private EditText editTajSzam;
    private Button btnMegse, btnMentes;
    private DBHelper adatbazis;
    public BeallitasokFragment() {
        // Required empty public constructor
    }
    public static BeallitasokFragment newInstance() {
        BeallitasokFragment fragment = new BeallitasokFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_beallitasok,
                container, false);
        editTextNev = rootView.findViewById(R.id.editTextNev);
        editSzulDatum = rootView.findViewById(R.id.editSzulDatum);
        dpSzulDatum = rootView.findViewById(R.id.dpSzulDatum);
        editTajSzam = rootView.findViewById(R.id.editTajSzam);
        btnMentes = rootView.findViewById(R.id.btnMentes);
        btnMegse = rootView.findViewById(R.id.btnMegse);

        try {
            int maxId = -1;
            Cursor c1 = adatbazis.legfrissebbId();
            if (c1.moveToFirst()) {
                maxId = c1.getInt(0);
            }
            c1.close();
            Cursor c2 = adatbazis.profilMegjelenites(maxId);
            while (c2.moveToNext()) {
                editTextNev.append(c2.getString(1));
                editTajSzam.append(c2.getString(3));
            }
            c2.close();
        }
        catch (Exception ex) {
            Toast.makeText(getActivity(),"Kérem adja meg a személyes adatait!", Toast.LENGTH_SHORT).show();
        }

        btnMentes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nev = editTextNev.getText().toString().trim();
                String tajString = editTajSzam.getText().toString().trim();
                String szulDatum = editSzulDatum.toString();
                if (nev.isEmpty() || tajString.isEmpty() || szulDatum.isEmpty()) {
                    Toast.makeText(getActivity(), "Minden mező kitöltése kötelező", Toast.LENGTH_SHORT).show();
                }
                else {
                    try {
                        int taj = Integer.parseInt(tajString);
                        if (adatbazis.profilHozzaadas(nev, szulDatum, taj)) {
                            Toast.makeText(getActivity(), "Sikeres művelet", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(getActivity(), "Sikertelen művelet", Toast.LENGTH_SHORT).show();
                        }
                    }
                    catch (NumberFormatException ex) {
                        Toast.makeText(getActivity(),"A TAJ számnak számnak kell lennie!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        btnMegse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Nem történt beállítás", Toast.LENGTH_SHORT).show();
                ((MainActivity) getActivity()).navigateToGyogyszereim();
            }
        });

        return rootView;
    }
}