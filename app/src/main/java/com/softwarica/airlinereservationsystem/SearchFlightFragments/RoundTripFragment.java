package com.softwarica.airlinereservationsystem.SearchFlightFragments;


import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.softwarica.airlinereservationsystem.R;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class RoundTripFragment extends Fragment implements DatePickerDialog.OnDateSetListener {
    private Spinner spinFrom, spinTo, spinNationality;
    private TextView tvDeparture, tvReturn;
    private EditText etTravellers;
    private Button btnSearch;


    public RoundTripFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_round_trip, container, false);

        // Getting application context
        Context context = getActivity();

        spinFrom = view.findViewById(R.id.spinFrom);
        spinTo = view.findViewById(R.id.spinTo);
        spinNationality = view.findViewById(R.id.spinNationality);
        tvDeparture = view.findViewById(R.id.tvDeparture);
        tvReturn = view.findViewById(R.id.tvReturn);
        etTravellers = view.findViewById(R.id.etTravellers);
        btnSearch = view.findViewById(R.id.btnSearch);

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

        tvDeparture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDeparture();
            }
        });

        tvReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadReturn();
            }
        });

        return view;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = + (month + 1) + "/" + dayOfMonth + "/" + year;
        tvDeparture.setText(date);

    }
    private void loadDeparture() {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                getActivity(), this,
                year, month, day);
        datePickerDialog.getDatePicker().setMinDate(c.getTimeInMillis());
        datePickerDialog.show();
    }

    private void loadReturn() {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String date =  + (month + 1) + "/" + dayOfMonth + "/" + year;
                tvReturn.setText(date);
            }
        }, year, month, day);
        datePickerDialog.getDatePicker().setMinDate(c.getTimeInMillis());
        datePickerDialog.show();
    }
    }
