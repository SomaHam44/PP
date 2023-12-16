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
 * Use the {@link FigyelmeztetesekFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FigyelmeztetesekFragment extends Fragment {
    private RecyclerView rvFigyelmeztetesek;
    private Button btnVissza, btnGyogyszertarKereso;

    public FigyelmeztetesekFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment FigyelmeztetesekFragment.
     */
    // TODO: Rename and change types and number of parameters
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
        /*btnGyogyszertarKereso.setOnClickListener(new View.OnClickListener() {
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
        return inflater.inflate(R.layout.fragment_figyelmeztetesek, container, false);
    }
}