package com.softwarica.airlinereservationsystem.SearchFlightFragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.softwarica.airlinereservationsystem.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RoundTripFragment extends Fragment {
    private Spinner spinFrom, spinTo, spinNationality;
    private EditText etDeparture, etTravellers;


    public RoundTripFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_round_trip, container, false);

        spinFrom = view.findViewById(R.id.spinFrom);
        spinTo = view.findViewById(R.id.spinTo);
        spinNationality = view.findViewById(R.id.spinNationality);
        etDeparture = view.findViewById(R.id.etDeparture);
        etTravellers = view.findViewById(R.id.etTravellers);

        String From [] = {"Kathmandu" , "Pokhara", "Janakpur" , "Nepalgunj", "Birtnagar"};
        final ArrayAdapter from = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                From
        );
        spinFrom.setAdapter(from);
//
        String To [] = {"Pokhara" , "Janakpur", "Kathmandu", "Nepalgunj", "Birtnagar"};
        final ArrayAdapter to = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                To
        );
        spinTo.setAdapter(to);

        String Nationality [] = {"Nepal"};
        final ArrayAdapter nationality = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                Nationality
        );
        spinNationality.setAdapter(nationality);

        return view;
    }

}
