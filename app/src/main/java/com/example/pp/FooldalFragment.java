package com.example.pp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FooldalFragment extends Fragment {

    private Button btnIndit;

    public FooldalFragment() {
        // Required empty public constructor
    }

    public static FooldalFragment newInstance() {
        FooldalFragment fragment = new FooldalFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_fooldal, container,
                false);
        btnIndit = rootView.findViewById(R.id.btnIndit);
        btnIndit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).navigateToGyogyszereim();
            }
        });

        return rootView;
    }
}