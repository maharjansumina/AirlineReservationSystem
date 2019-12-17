package com.softwarica.airlinereservationsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.softwarica.airlinereservationsystem.SearchFlightFragments.OneTripFragment;
import com.softwarica.airlinereservationsystem.SearchFlightFragments.RoundTripFragment;

public class SearchFlightActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnOne, btnRound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_flight);

        btnOne = findViewById(R.id.btnOne);
        btnRound = findViewById(R.id.btnRound);

        btnOne.setOnClickListener(this);
        btnRound.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        switch (v.getId()) {
            case R.id.btnOne:
                OneTripFragment oneTripFragment = new OneTripFragment();
                fragmentTransaction.replace(R.id.FragmentContainer, oneTripFragment);
                fragmentTransaction.commit();
                break;

            case R.id.btnRound:
                RoundTripFragment roundTripFragment = new RoundTripFragment();
                fragmentTransaction.replace(R.id.FragmentContainer, roundTripFragment);
                fragmentTransaction.commit();
                break;
        }
    }
}
