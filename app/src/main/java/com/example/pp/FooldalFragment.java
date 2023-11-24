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

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String NAME_PARAM = "name";
    private String mName;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FooldalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment FooldalFragment.
     */
    // TODO: Rename and change types and number of parameters
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