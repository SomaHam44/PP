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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GyogyszereimFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GyogyszereimFragment extends Fragment {
    private RecyclerView rvGyogyszereim;
    private Button btnHozzaad, btnTovabb;

    public GyogyszereimFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static GyogyszereimFragment newInstance() {
        GyogyszereimFragment fragment = new GyogyszereimFragment();
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
        /*btnTovabb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnHozzaad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        */

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gyogyszereim, container, false);
    }
}