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
 * Use the {@link GyogyszerReszletekFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GyogyszerReszletekFragment extends Fragment {
    private EditText editTextNev;
    private EditText editTextHatoanyag;
    private EditText editTextTajSzam;
    private EditText editTextLink;
    private CheckBox cbRendszeres;
    private RecyclerView rvIdopontok;
    private Button btnVissza, btnMentes;

    public GyogyszerReszletekFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment GyogyszerReszletekFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GyogyszerReszletekFragment newInstance() {
        GyogyszerReszletekFragment fragment = new GyogyszerReszletekFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_gyogyszer_reszletek, container, false);
        editTextNev = rootView.findViewById(R.id.editTextNev);
        editTextHatoanyag = rootView.findViewById(R.id.editTextHatoanyag);
        editTextTajSzam = rootView.findViewById(R.id.editTextTajSzam);
        editTextLink = rootView.findViewById(R.id.editTextLink);
        rvIdopontok = rootView.findViewById(R.id.idopontok);
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

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gyogyszer_reszletek, container, false);
    }
}