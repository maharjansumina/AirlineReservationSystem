package com.softwarica.airlinereservationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class EditProfileActivity extends AppCompatActivity {

    EditText etUName, etUAddress, etUPhone, etUEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        etUName = findViewById(R.id.etUName);
        etUAddress = findViewById(R.id.etUAddress);
        etUPhone = findViewById(R.id.etUPhone);
        etUEmail = findViewById(R.id.etUEmail);
    }
}
