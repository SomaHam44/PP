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
 * Use the {@link GyogyszerHozzaadasaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GyogyszerHozzaadasaFragment extends Fragment {
    private EditText editTextNev;
    private EditText editTextHatoanyago;
    private EditText editTextSzam;
    private EditText editTextLink;
    private CheckBox cbRendszeres;
    private RecyclerView rvAdagolas;
    private Button btnVissza, btnMentes;

    private DBHelper adatbazis;

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
        adatbazis = new DBHelper(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_gyogyszer_hozzaadasa, container, false);
        editTextNev = rootView.findViewById(R.id.editTextNev);
        editTextHatoanyago = rootView.findViewById(R.id.editTextHatoanyago);
        editTextSzam = rootView.findViewById(R.id.editTextNumber);
        editTextLink = rootView.findViewById(R.id.editTextLink);
        cbRendszeres = rootView.findViewById(R.id.checkBox);
        rvAdagolas = rootView.findViewById(R.id.idopontok);
        btnVissza = rootView.findViewById(R.id.btnVissza);
        btnMentes = rootView.findViewById(R.id.btnMentes);

        // Inflate the layout for this fragment
        btnMentes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nev = editTextNev.getText().toString().trim();
                String hatoanyag = editTextHatoanyago.getText().toString().trim();
                String szamString = editTextSzam.getText().toString().trim();
                String link = editTextLink.getText().toString().trim();
                if (nev.isEmpty() || hatoanyag.isEmpty() || szamString.isEmpty() || link.isEmpty()) {
                    Toast.makeText(getActivity(), "Minden mező kitöltése kötelező", Toast.LENGTH_SHORT).show();
                }
                else {
                    try {
                        int szam = Integer.parseInt(szamString);

                    }
                    catch (NumberFormatException ex){
                        Toast.makeText(getActivity(), "Számnak kell lennie", Toast.LENGTH_SHORT).show();

                    }
                }


            }
        });

        /*btnVissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        */

        return inflater.inflate(R.layout.fragment_gyogyszer_hozzaadasa, container, false);
    }
}