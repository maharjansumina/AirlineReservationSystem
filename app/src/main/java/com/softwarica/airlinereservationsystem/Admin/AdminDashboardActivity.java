package com.softwarica.airlinereservationsystem.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.softwarica.airlinereservationsystem.R;

public class AdminDashboardActivity extends AppCompatActivity implements View.OnClickListener{

    CardView cvViewUser, cvAdminProfile, cvViewContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        cvViewUser = findViewById(R.id.cvViewUser);
        cvAdminProfile = findViewById(R.id.cvAdminProfile);
        cvViewContact = findViewById(R.id.cvViewContact);

        cvViewUser.setOnClickListener(this);
        cvAdminProfile.setOnClickListener(this);
        cvViewContact.setOnClickListener(this);
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
        }

    }
}
