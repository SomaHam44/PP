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
    private Button btnFelvesz, btnTovabb;

    public VasarlasRogziteseFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment VasarlasRogziteseFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VasarlasRogziteseFragment newInstance() {
        VasarlasRogziteseFragment fragment = new VasarlasRogziteseFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_vasarlas_rogzitese, container, false);
        editTextKiszereles = rootView.findViewById(R.id.editTextKiszereles);
        dpLejarat = rootView.findViewById(R.id.lejarat);
        /*btnTovabb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnFelvesz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        */
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vasarlas_rogzitese, container, false);
    }
}