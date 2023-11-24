package com.example.pp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BeallitasokFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BeallitasokFragment extends Fragment {
    private static final String NAME_PARAM = "name";
    private String mName;

    public BeallitasokFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     *
     * @return A new instance of fragment ProfilFragment.
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
        if (getArguments() != null) {
            mName = getArguments().getString(NAME_PARAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_beallitasok,
                container, false);
       /* final EditText profileEditText =
                rootView.findViewById(R.id.profileEditText);


        if(mName != null) {
            profileEditText.setText(mName);
        }
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