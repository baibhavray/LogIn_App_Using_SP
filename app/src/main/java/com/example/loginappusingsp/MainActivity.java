package com.example.loginappusingsp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etLogIn,etPassword;
    Button btnSignIn,btnCancel;
    SharedPreferences sp;
    SharedPreferences.Editor edit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etLogIn = findViewById(R.id.etLogIn);
        etPassword = findViewById(R.id.etPassword);
        btnSignIn = findViewById(R.id.btnSignIn);
        btnCancel = findViewById(R.id.btnCancel);

        sp = getSharedPreferences("mypref",MODE_PRIVATE);
        edit = sp.edit();

        String loginid = sp.getString("key1loginid",null);
        if(loginid!=null)
        {
            Intent i = new Intent(MainActivity.this,HomeActivity.class);
            startActivity(i);
        }



        btnSignIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                String loginid = etLogIn.getText().toString();
                String password = etPassword.getText().toString();

                if(loginid.equals("admin") && password.equals("1234"))
                {
                    edit.putString("key3loginid",loginid);
                    edit.commit();

                    Intent i = new Intent(MainActivity.this,HomeActivity.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Invalid Credentials",Toast.LENGTH_LONG).show();
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etLogIn.setText("");
                etPassword.setText("");
            }
        });
    }
}