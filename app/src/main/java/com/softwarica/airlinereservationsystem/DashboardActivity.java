package com.softwarica.airlinereservationsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.softwarica.airlinereservationsystem.BookingDetail.SearchFlightActivity;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView cvSearhFlight, cvProfile, cvContactUs, cvCancel, cvLogout, cvMap;
    private TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //Blinding
        cvSearhFlight = findViewById(R.id.cvSearchFlight);
        cvProfile = findViewById(R.id.cvProfile);
        cvContactUs = findViewById(R.id.cvContactUs);
        cvCancel = findViewById(R.id.cvCancel);
        cvLogout = findViewById(R.id.cvLogout);
        cvMap = findViewById(R.id.cvMap);
        tvName = findViewById(R.id.tvName);

        cvSearhFlight.setOnClickListener(this);
        cvProfile.setOnClickListener(this);
        cvContactUs.setOnClickListener(this);
        cvCancel.setOnClickListener(this);
        cvLogout.setOnClickListener(this);
        cvMap.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cvSearchFlight:
                startActivity(new Intent(this, SearchFlightActivity.class));
                break;

            case R.id.cvContactUs:
                startActivity(new Intent(this, ContactUsActivity.class));
                break;

            case R.id.cvCancel:
                startActivity(new Intent(this, CancelBookingActivity.class));
                break;

            case R.id.cvProfile:
                startActivity(new Intent(this, ProfileActivity.class));
                break;

//            case R.id.cvLogout:
//                startActivity(new Intent(this, LoginActivity.class));
//                //Intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);// clear back stack
//                break;
        }
    }
}
