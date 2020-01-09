package com.example.darazapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class LoginActivity extends AppCompatActivity {

    private TabLayout tablayout;
    private ViewPager viewpager;
    private Button btnfacebook, btngoogle;
    private TabItem tbpassword,tbsms;
    private TextView tvcreateaccount;
    private EditText etusername,etpassword;
    public LoginPageAdapter loginPageAdapter;
    private boolean status = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tablayout = findViewById(R.id.tablayout);
        viewpager = findViewById(R.id.viewpager);
        tbpassword = findViewById(R.id.tbpassword);
        tbsms = findViewById(R.id.tbsms);
        loginPageAdapter = new LoginPageAdapter(getSupportFragmentManager(),tablayout.getTabCount());
        viewpager.setAdapter(loginPageAdapter);
        etusername = findViewById(R.id.etusername);
        etpassword = findViewById(R.id.etpassword);
        btnfacebook = findViewById(R.id.btnfacebook);
        btngoogle = findViewById(R.id.btngoogle);
        tvcreateaccount = findViewById(R.id.tvcreateac);

        tvcreateaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });

        btnfacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkfbPermission();
            }
        });

        btngoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checlgooglePermission();
            }
        });

        




    }
}
