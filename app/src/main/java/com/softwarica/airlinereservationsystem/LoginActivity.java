package com.softwarica.airlinereservationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.softwarica.airlinereservationsystem.API.UsersAPI;
import com.softwarica.airlinereservationsystem.Admin.AdminDashboardActivity;
import com.softwarica.airlinereservationsystem.bll.LoginBLL;
import com.softwarica.airlinereservationsystem.model.User;
import com.softwarica.airlinereservationsystem.strictmode.StrictModeClass;
import com.softwarica.airlinereservationsystem.url.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
                String email = etEmail.getText().toString();
                String pwd = etPassword.getText().toString();

                LoginBLL loginBLL = new LoginBLL();
                StrictModeClass.StrictMode();

                if (loginBLL.checkUser(email, pwd)) {

                    UsersAPI usersAPI = URL.getInstance().create(UsersAPI.class);
                    Call<User> userCall = usersAPI.getUserDetails(URL.token);
                    userCall.enqueue(new Callback<User>() {
                        @Override
                        public void onResponse(Call<User> call, Response<User> response) {
                            if (!response.isSuccessful()) {
                                Toast.makeText(LoginActivity.this, "error", Toast.LENGTH_SHORT).show();
                            } else {
                                String admin = response.body().getAdmin();

                                if (admin == "false") {
                                    Toast.makeText(LoginActivity.this, "Login Sucessfully " + admin, Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(LoginActivity.this, "Login Sucessfully " + admin, Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(LoginActivity.this, AdminDashboardActivity.class);
                                    startActivity(intent);
                                    finish();
                                }

                            }
                        }

                        @Override
                        public void onFailure(Call<User> call, Throwable t) {
                            Toast.makeText(LoginActivity.this, "error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                        }
                    });


                } else {
                    Toast.makeText(LoginActivity.this, "Email or password donot match", Toast.LENGTH_SHORT).show();
                    etEmail.setText("");
                    etPassword.setText("");
                    etEmail.requestFocus();
                }

            }
        });

    }
}





