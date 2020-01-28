package com.softwarica.airlinereservationsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.softwarica.airlinereservationsystem.BookingDetail.SearchFlightActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //using a thread and halt screen for 2 seconds
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences = getSharedPreferences("User", MODE_PRIVATE);
                String email = sharedPreferences.getString("email", "");
                String password = sharedPreferences.getString("password", "");

                if (email.equals("admin") && password.equals("admin")) {
                    startActivity(new Intent(SplashScreenActivity.this, DashboardActivity.class));

                }

                else  {
                    Toast.makeText(SplashScreenActivity.this, "Wrong Email or Password", Toast.LENGTH_SHORT).show();
                }
            }
        }, 2000);

    }
}
