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
 * Use the {@link FigyelmeztetesekFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FigyelmeztetesekFragment extends Fragment {
    private RecyclerView rvFigyelmeztetesek;
    private Button btnVissza, btnGyogyszertarKereso;

    public FigyelmeztetesekFragment() {
        // Required empty public constructor
    }
    public static FigyelmeztetesekFragment newInstance() {
        FigyelmeztetesekFragment fragment = new FigyelmeztetesekFragment();
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
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_figyelmeztetesek, container, false);
        rvFigyelmeztetesek = rootView.findViewById(R.id.figyelmeztetesekLista);
        btnGyogyszertarKereso = rootView.findViewById(R.id.btnGyogyszertarKeresohoz);
        btnVissza = rootView.findViewById(R.id.btnFigyelmeztetesekVissza);
        btnGyogyszertarKereso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).navigateToGyogyszertarKereso();
            }
        });

        btnVissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Visszatérés", Toast.LENGTH_SHORT).show();
                ((MainActivity) getActivity()).navigateToGyogyszereim();
            }
        });
        return rootView;
    }
}