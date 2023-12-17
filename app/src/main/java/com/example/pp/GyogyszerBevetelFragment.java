package com.example.pp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GyogyszerBevetelFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GyogyszerBevetelFragment extends Fragment {
    private Button btnMentes;
    private Button btnLista, btnVissza, btnMinden, btnSemmi;
    private RecyclerView rvGyogyszerLista;
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


        /*btnMentes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        */
        return rootView;
    }
}