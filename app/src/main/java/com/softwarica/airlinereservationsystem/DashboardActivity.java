package com.softwarica.airlinereservationsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView cvSearhFlight, cvEditBooking, cvProfile, cvFeedback, cvCancel, cvLogout;
    private TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //Blinding
        cvSearhFlight = findViewById(R.id.cvSearchFlight);
        cvEditBooking = findViewById(R.id.cvEditBooking);
        cvProfile = findViewById(R.id.cvProfile);
        cvFeedback = findViewById(R.id.cvFeedback);
        cvCancel = findViewById(R.id.cvCancel);
        cvLogout = findViewById(R.id.cvLogout);
        tvName = findViewById(R.id.tvName);
        cvSearhFlight.setOnClickListener(this);
        cvEditBooking.setOnClickListener(this);
        cvProfile.setOnClickListener(this);
        cvFeedback.setOnClickListener(this);
        cvCancel.setOnClickListener(this);
        cvLogout.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

    }
}
