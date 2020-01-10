package com.example.darazapplication;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LoginSignupActivity extends AppCompatActivity {

    private Button btncreate, btnlogin, btnfacebook, btngoogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_signup);

        btncreate = findViewById(R.id.btncreateaccount);
        btnlogin = findViewById(R.id.btnlogin);
        btnfacebook = findViewById(R.id.btnfb);
        btngoogle = findViewById(R.id.btngoogle);



    }
}
