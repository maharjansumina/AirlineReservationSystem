package com.softwarica.airlinereservationsystem.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.softwarica.airlinereservationsystem.API.UsersAPI;
import com.softwarica.airlinereservationsystem.R;
import com.softwarica.airlinereservationsystem.model.User;
import com.softwarica.airlinereservationsystem.url.URL;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewUserdetailActivity extends AppCompatActivity {

    private TextView tvViewUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_userdetail);

        tvViewUser = findViewById(R.id.tvViewUser);

        UsersAPI usersAPI = URL.getInstance().create(UsersAPI.class);
        Call<List<User>> listCall = usersAPI.getUser(URL.token);

        listCall.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(ViewUserdetailActivity.this, "Error" + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                List<User> userList = response.body();

                for (User user : userList) {
                    String data = "";
                    data += "Name is : " + user.getFullname() + "\n";
                    data += "Address is : " + user.getAddress() + "\n";
                    data += "Phone Number is : " + user.getPhone() + "\n";
                    data += "Email is : " + user.getEmail() + "\n";
                    data += "Profile is : " + user.getImage() + "\n";

                    tvViewUser.append(data);
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

                Log.d("Msg","onFailure: " + t.getLocalizedMessage());
                Toast.makeText(ViewUserdetailActivity.this, "Error" + t.getLocalizedMessage() , Toast.LENGTH_SHORT).show();

            }
        });
    }
}
