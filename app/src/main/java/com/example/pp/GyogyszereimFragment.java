package com.example.pp;

import android.database.Cursor;
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

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GyogyszereimFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GyogyszereimFragment extends Fragment {
    private RecyclerView gyogyszerLista;
    private Button btnHozzaad, btnMegse;
    private DBHelper adatbazis;

    public GyogyszereimFragment() {
        // Required empty public constructor
    }
    public static GyogyszereimFragment newInstance() {
        GyogyszereimFragment fragment = new GyogyszereimFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_gyogyszereim, container, false);
        gyogyszerLista= rootView.findViewById(R.id.gyogyszerLista);
        btnHozzaad = rootView.findViewById(R.id.btnHozzaad);
        btnMegse = rootView.findViewById(R.id.btnMegse);
        List<Gyogyszer> gyogyszeresLista = new ArrayList<>();
        try {
            Cursor c = adatbazis.listazas();
            while (c.moveToNext()) {

            }
            c.close();
        }
        catch (Exception ex) {
            Toast.makeText(getActivity(),"Kérem adjon hozzá gyógyszert a listához!", Toast.LENGTH_SHORT).show();
        }


        return rootView;
    }
}