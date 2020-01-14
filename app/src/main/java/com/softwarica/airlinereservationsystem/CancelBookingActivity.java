package com.softwarica.airlinereservationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CancelBookingActivity extends AppCompatActivity {

    EditText etFlightId;
    TextView tvData;
    Button btnCancel, btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel_booking);

        etFlightId = findViewById(R.id.etFlightId);
        tvData = findViewById(R.id.tvData);
        btnCancel = findViewById(R.id.btnCancel);
        btnSearch = findViewById(R.id.btnSearch);
    }
}
