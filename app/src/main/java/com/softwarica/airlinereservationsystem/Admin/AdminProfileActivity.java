package com.softwarica.airlinereservationsystem.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.softwarica.airlinereservationsystem.API.UsersAPI;
import com.softwarica.airlinereservationsystem.R;
import com.softwarica.airlinereservationsystem.model.User;
import com.softwarica.airlinereservationsystem.url.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AdminProfileActivity extends AppCompatActivity {

    private TextView tvAdminName, tvAdminAddress, tvAdminPhone, tvAdminEmail;
    private Button btnEditAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_profile);

        tvAdminName = findViewById(R.id.tvAdminName);
        tvAdminAddress = findViewById(R.id.tvAdminAddress);
        tvAdminPhone = findViewById(R.id.tvAdminPhone);
        tvAdminEmail = findViewById(R.id.tvAdminEmail);

        UsersAPI usersAPI = URL.getInstance().create(UsersAPI.class);
        Call<User> user = usersAPI.getUserDetails(URL.token);

        user.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(AdminProfileActivity.this, "Error" + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                tvAdminName.setText(response.body().getFullname());
                tvAdminAddress.setText(response.body().getAddress());
                tvAdminPhone.setText(response.body().getPhone());
                tvAdminEmail.setText(response.body().getEmail());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

                Log.d("Msg", "onFailure: " + t.getLocalizedMessage());
                Toast.makeText(AdminProfileActivity.this, "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
