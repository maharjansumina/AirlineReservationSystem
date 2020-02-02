package com.softwarica.airlinereservationsystem.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.softwarica.airlinereservationsystem.R;

public class AddFlightActivity extends AppCompatActivity {

    EditText etFlightFrom, etFlightTo, etTime;
    Button btnAddFlight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_flight);

        etFlightFrom = findViewById(R.id.etFlightFrom);
        etFlightTo = findViewById(R.id.etFlightTo);
        etTime = findViewById(R.id.etTime);
    }
}
