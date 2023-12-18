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
    private Button btnVissza, btnMentes;
    private DBHelper adatbazis;

    private TextView napszam;
    private int napok;

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
        napszam.findViewById(R.id.napszam);

        Gyogyszer gyogyszer = ((MainActivity)getActivity()).getSelectedGyogyszer();
        TextViewSelectedID.setText(gyogyszer.getId());
        editTextNev.append(gyogyszer.getNev());
        editTextHatoanyag.append(gyogyszer.getHatoanyag());
        editTextLink.append(gyogyszer.getLink());
        editTextNapi.append(gyogyszer.getStringNapi());
        editTextKeszlet.append(gyogyszer.getStringKeszlet());





        btnMentes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnVissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gyogyszer_reszletek, container, false);
    }
}