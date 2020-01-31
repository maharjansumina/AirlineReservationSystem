package com.softwarica.airlinereservationsystem.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.softwarica.airlinereservationsystem.API.UsersAPI;
import com.softwarica.airlinereservationsystem.R;
import com.softwarica.airlinereservationsystem.model.Contact;
import com.softwarica.airlinereservationsystem.url.URL;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewContactusActivity extends AppCompatActivity {

    private TextView tvViewContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_contactus);

        tvViewContact = findViewById(R.id.tvViewContact);

        UsersAPI usersAPI = URL.getInstance().create(UsersAPI.class);
        Call<List<Contact>> listCall = usersAPI.getContact(URL.token);

        listCall.enqueue(new Callback<List<Contact>>() {
            @Override
            public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(ViewContactusActivity.this, "Error" + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                List<Contact> contactList = response.body();

                for (Contact contact : contactList){
                    String data = "";
                    data += "Name is :" +contact.getFullname() + "\n";
                    data += "Email is :" +contact.getEmail() + "\n";
                    data += "Message is :" +contact.getMessage() + "\n";

                    tvViewContact.append(data);
                }
            }

            @Override
            public void onFailure(Call<List<Contact>> call, Throwable t) {

                Log.d("Msg" ,"onFailure:" + t.getLocalizedMessage());
                Toast.makeText(ViewContactusActivity.this, "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
