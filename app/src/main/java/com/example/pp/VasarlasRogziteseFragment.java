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
 * Use the {@link VasarlasRogziteseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VasarlasRogziteseFragment extends Fragment {
    private EditText editTextKiszereles;
    private DatePicker dpLejarat;
    private Button btnFelvesz, btnTovabb, btnVissza, btnHozzaado;
    private RecyclerView rvVasarlasLista;
    private DBHelper adatbazis;
    public VasarlasRogziteseFragment() {
        // Required empty public constructor
    }
    public static VasarlasRogziteseFragment newInstance() {
        VasarlasRogziteseFragment fragment = new VasarlasRogziteseFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_vasarlas_rogzitese, container, false);
        btnFelvesz = rootView.findViewById(R.id.btnFelvesz);
        editTextKiszereles = rootView.findViewById(R.id.editTextKiszereles);
        dpLejarat = rootView.findViewById(R.id.dpLejarat);
        btnTovabb = rootView.findViewById(R.id.btnTovabb);
        btnVissza = rootView.findViewById(R.id.btnVissza);
        rvVasarlasLista = rootView.findViewById(R.id.vasarlasLista);
        btnHozzaado = rootView.findViewById(R.id.btnHozzaado);
        btnTovabb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnFelvesz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnVissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnHozzaado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        // Inflate the layout for this fragment
        return rootView;
    }
}