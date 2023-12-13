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
 * Use the {@link BeallitasokFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BeallitasokFragment extends Fragment {
    private EditText editTextNev;
    private DatePicker datePicker;
    private EditText editTajSzam;
    private CheckBox cbRendszeres;
    private RecyclerView rvIdopontok;
    private Button btnVissza, btnTovabb;

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