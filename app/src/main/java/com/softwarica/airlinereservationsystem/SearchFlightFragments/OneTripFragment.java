package com.softwarica.airlinereservationsystem.SearchFlightFragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softwarica.airlinereservationsystem.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OneTripFragment extends Fragment {


    public OneTripFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one_trip, container, false);
    }

}
