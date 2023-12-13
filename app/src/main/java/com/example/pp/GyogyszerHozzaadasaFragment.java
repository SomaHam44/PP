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
 * Use the {@link GyogyszerHozzaadasaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GyogyszerHozzaadasaFragment extends Fragment {
    private EditText editTextNev;
    private EditText editTextHatoanyag;
    private EditText editTextSzam;
    private EditText editTextLink;
    private CheckBox cbRendszeres;
    private RecyclerView rvAdagolas;
    private Button btnVissza, btnMentes;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GyogyszerHozzaadasaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment GyogyszerHozzaadasaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GyogyszerHozzaadasaFragment newInstance() {
        GyogyszerHozzaadasaFragment fragment = new GyogyszerHozzaadasaFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        /*btnMentes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnVissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        */
        return inflater.inflate(R.layout.fragment_gyogyszer_hozzaadasa, container, false);
    }
}