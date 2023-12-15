package com.example.pp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
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
 * Use the {@link BeallitasokFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BeallitasokFragment extends Fragment {
    private EditText editTextNev;
    private DatePicker editSzulDatum;
    private EditText editTajSzam;
    private Button btnMegse, btnMentes;

    private DBHelper adatbazis;

    public BeallitasokFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     *.
     */
    // TODO: Rename and change types and number of parameters
    public static BeallitasokFragment newInstance() {
        BeallitasokFragment fragment = new BeallitasokFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_beallitasok,
                container, false);
        editTextNev =
                rootView.findViewById(R.id.editTextNev);

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
                        if (adatbazis.profilModositas(1, nev, szulDatum, taj)) {
                            Toast.makeText(getActivity(), "Sikeres felvétel", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(getActivity(), "Sikertelen felvétel", Toast.LENGTH_SHORT).show();
                        }
                    }
                    catch (NumberFormatException ex) {
                        Toast.makeText(getActivity(),"Az elkészítési időnek és az árnak számnak kell lennie!", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });


        /*btnTovabb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnVissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        /*Button cancelButton = rootView.findViewById(R.id.cancelButton);
        Button saveButton = rootView.findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = profileEditText.getText().toString();
                ((MainActivity)getActivity()).profileSave(name);
            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).profileCancel();
            }
        });
        */
        return rootView;

    }
}