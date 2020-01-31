package com.softwarica.airlinereservationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.softwarica.airlinereservationsystem.API.UsersAPI;
import com.softwarica.airlinereservationsystem.model.Contact;
import com.softwarica.airlinereservationsystem.model.User;
import com.softwarica.airlinereservationsystem.serverresponse.RegisterResponse;
import com.softwarica.airlinereservationsystem.url.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContactUsActivity extends AppCompatActivity {

    EditText etName, etEmail, etMessage;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        //Blinding
        etMessage = findViewById(R.id.etMessage);
        btnSubmit=findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contact();
            }
        });
    }

    private void contact() {
        UsersAPI usersAPI = URL.getInstance().create(UsersAPI.class);
        Call<User> userCall=usersAPI.getUserDetails(URL.token);
        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                String fullname = response.body().getFullname();
                String email = response.body().getEmail();
                String message = etMessage.getText().toString();

                Contact contacts = new Contact(fullname, email, message);

                UsersAPI usersAPI = URL.getInstance().create(UsersAPI.class);
                Call<Void> registerCall = usersAPI.contactUs(URL.token, fullname, email, message);

                registerCall.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (! response.isSuccessful())
                        {
                            Toast.makeText(ContactUsActivity.this, "error"+response.code(), Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(ContactUsActivity.this, "Contacgt added sucessfully", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(ContactUsActivity.this, "error", Toast.LENGTH_SHORT).show();
                    }
                });

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(ContactUsActivity.this, "error", Toast.LENGTH_SHORT).show();
            }
        });



    }
}
