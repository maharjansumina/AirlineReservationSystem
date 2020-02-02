package com.softwarica.airlinereservationsystem.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.softwarica.airlinereservationsystem.LoginActivity;
import com.softwarica.airlinereservationsystem.R;

public class AdminDashboardActivity extends AppCompatActivity implements View.OnClickListener{

    CardView cvViewUser, cvAdminProfile, cvViewContact, cvAdminLogout, cvAddFlight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        cvViewUser = findViewById(R.id.cvViewUser);
        cvAdminProfile = findViewById(R.id.cvAdminProfile);
        cvViewContact = findViewById(R.id.cvViewContact);
        cvAdminLogout = findViewById(R.id.cvAdminLogout);
        cvAddFlight = findViewById(R.id.cvAddFlight);

        cvViewUser.setOnClickListener(this);
        cvAdminProfile.setOnClickListener(this);
        cvViewContact.setOnClickListener(this);
        cvAddFlight.setOnClickListener(this);
        cvAdminLogout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cvViewUser:
                startActivity(new Intent(this, ViewUserdetailActivity.class));
                break;

            case R.id.cvAdminProfile:
                startActivity(new Intent(this, AdminProfileActivity.class));
                break;

            case R.id.cvViewContact:
                startActivity(new Intent(this, ViewContactusActivity.class));
                break;

            case R.id.cvAddFlight:
                startActivity(new Intent(this, AddFlightActivity.class));
                break;

            case R.id.cvAdminLogout:
                startActivity(new Intent(this, LoginActivity.class));
                finish();
                break;
        }

    }
}
