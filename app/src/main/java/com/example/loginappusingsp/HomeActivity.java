package com.example.loginappusingsp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    TextView tvMessage;
    Button btnLogout;
    SharedPreferences sp;
    SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tvMessage = findViewById(R.id.tvMessage);
        btnLogout = findViewById(R.id.btnLogout);

        sp = getSharedPreferences("mypref",MODE_PRIVATE);
        edit = sp.edit();

        String loginid = sp.getString("sp_loginid_key",null);
        tvMessage.setText(loginid);




        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit.clear();
                edit.commit();
                Intent i = new Intent(HomeActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}