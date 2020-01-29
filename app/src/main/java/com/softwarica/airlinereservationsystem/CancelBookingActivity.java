package com.softwarica.airlinereservationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CancelBookingActivity extends AppCompatActivity {

    TextView tvData;
    Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel_booking);

        tvData = findViewById(R.id.tvData);
        btnCancel = findViewById(R.id.btnCancel);
    }
}
