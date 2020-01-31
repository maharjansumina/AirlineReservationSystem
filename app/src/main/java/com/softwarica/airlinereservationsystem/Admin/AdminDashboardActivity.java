package com.softwarica.airlinereservationsystem.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.softwarica.airlinereservationsystem.BookingDetail.SearchFlightActivity;
import com.softwarica.airlinereservationsystem.ContactUsActivity;
import com.softwarica.airlinereservationsystem.R;

public class AdminDashboardActivity extends AppCompatActivity implements View.OnClickListener{

    private CardView cvViewUser, cvAdminProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        cvAdminProfile = findViewById(R.id.cvAdminProfile);
        cvViewUser = findViewById(R.id.cvCancel);
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
        }
    }
}
