package com.softwarica.airlinereservationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.softwarica.airlinereservationsystem.bll.LoginBLL;
import com.softwarica.airlinereservationsystem.strictmode.StrictModeClass;

public class LoginActivity extends AppCompatActivity {

    EditText etEmail, etPassword;
    TextView tvRegisterLink;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Blinding
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        tvRegisterLink = findViewById(R.id.tvRegisterLink);

        tvRegisterLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

        private void login() {
            String email = etEmail.getText().toString();
            String password = etPassword.getText().toString();

            LoginBLL loginBLL = new LoginBLL();

            StrictModeClass.StrictMode();
            if (loginBLL.checkUser(email, password)) {
                Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "Either email or password is incorrect", Toast.LENGTH_SHORT).show();
                etEmail.requestFocus();
            }

        }
}
