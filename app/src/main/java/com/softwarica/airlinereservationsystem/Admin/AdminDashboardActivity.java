package com.softwarica.airlinereservationsystem.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.softwarica.airlinereservationsystem.R;

public class AdminDashboardActivity extends AppCompatActivity implements View.OnClickListener{

    CardView cvViewUser, cvAdminProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        cvViewUser = findViewById(R.id.cvViewUser);
        cvAdminProfile = findViewById(R.id.cvAdminProfile);

        cvViewUser.setOnClickListener(this);
        cvAdminProfile.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cvViewUser:
                startActivity(new Intent(this, ViewUserdetailActivity.class));
                break;
        }

    }
}
