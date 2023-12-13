package com.example.pp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        btnMentes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return inflater.inflate(R.layout.fragment_gyogyszer_bevetel, container, false);
    }
}