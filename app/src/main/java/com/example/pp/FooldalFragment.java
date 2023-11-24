package com.example.pp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FooldalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FooldalFragment extends Fragment {
    private static final String NAME_PARAM = "name";
    private String mName;

    public FooldalFragment() {
        // Required empty public constructor
    }

    public static FooldalFragment newInstance(String name) {
        FooldalFragment fragment = new FooldalFragment();
        Bundle args = new Bundle();
        args.putString(NAME_PARAM, name);
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
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_fooldal, container,
                false);
        TextView profileNameTextView =
                rootView.findViewById(R.id.profileNameTextView);
        if(mName != null) {
            profileNameTextView.setText(mName);
        }
        return rootView;
    }
}