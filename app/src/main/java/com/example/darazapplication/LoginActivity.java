package com.example.darazapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
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
        tbpassword = findViewById(R.id.tabpassword);
        tbsms = findViewById(R.id.tabsms);
        loginPageAdapter = new LoginPageAdapter(getSupportFragmentManager(),tablayout.getTabCount());
        viewpager.setAdapter(loginPageAdapter);
        etusername = findViewById(R.id.etname);
        etpassword = findViewById(R.id.etpassword);
        btnfacebook = findViewById(R.id.btnfb);
        btngoogle = findViewById(R.id.btngoogle);
        tvcreateaccount = findViewById(R.id.tvcreateacc);

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
                checkgooglePermission();
            }
        });

        tablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewpager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0)
                {
                    loginPageAdapter.notifyDataSetChanged();

                }
                else if (tab.getPosition() == 1)
                {
                    loginPageAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));

    }

    private void checkfbPermission()
    {
        new AlertDialog.Builder(this)
                .setTitle("Policy Aggrement")
                .setMessage("I agree to all the Terms and Conditions of usage and for all the personal data to be processed " +
                        "According to all the Daraz Applications Privacy Policy")
                .setPositiveButton("Allow", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                       String url = "https://www.facebook.com/";

                       Intent intent = new Intent(Intent.ACTION_VIEW);
                       intent.setData(Uri.parse(url));
                       startActivity(intent);
                    }
                })
                .setNegativeButton("Deny", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();

                    }
                })
                .create().show();
    }

    private void checkgooglePermission()
    {
        new AlertDialog.Builder(this)
                .setTitle("I agree to all the Terms and Conditions of usage and for all the personal data to be processed " +
                        "According to all the Daraz Applications Privacy Policy")
                .setPositiveButton("Allow", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String url = "https://www.google.com/";

                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(url));
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Deny", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();

                    }
                })
                .create().show();
    }

}
