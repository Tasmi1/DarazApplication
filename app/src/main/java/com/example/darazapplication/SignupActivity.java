package com.example.darazapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.darazapplication.API.UserAPI;
import com.example.darazapplication.ServerResponse.SignUpResponse;
import com.example.darazapplication.URL.Url;
import com.example.darazapplication.modalClass.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {

    private Button btnfb,btngoogle,btnsignup;
    private TextView tvlogin;

    private EditText etfname,etusername,etpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        btnfb = findViewById(R.id.btnfb);
        btngoogle = findViewById(R.id.btngoogle);
        tvlogin = findViewById(R.id.tvlogin);
        etfname = findViewById(R.id.etname);
        etusername = findViewById(R.id.txtpusername);
        etpassword = findViewById(R.id.etpassword);
        btnsignup = findViewById(R.id.btnsignup);


        tvlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this,LoginActivity.class);
                startActivity(intent);

            }
        });

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signup();
            }
        });

        btnfb.setOnClickListener(new View.OnClickListener() {
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





    }

    private void checkfbPermission() {


        new AlertDialog.Builder(this)
                .setTitle("Policy Aggreement")
                .setMessage("I agree to Daraz's Terms of usage and for my personal data to be processed " +
                        "according to Daraz Privacy Policy")
                .setPositiveButton("Allow", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String url = "https://www.facebook.com/";

                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(url));
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Deny", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create().show();

    }

    private void checkgooglePermission() {

        new AlertDialog.Builder(this)
                .setTitle("Policy Aggreement")
                .setMessage("I agree to Daraz's Terms of usage and for my personal data to be processed " +
                        "according to Daraz Privacy Policy")
                .setPositiveButton("Allow", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String url = "https://www.google.com/";

                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);
                    }
                })
                .setNegativeButton("Deny", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create().show();
    }

    private  void signup()
    {
        String fullname = etfname.getText().toString();
        String username = etusername.getText().toString();
        String password = etpassword.getText().toString();

        User users = new User(fullname, username, password);

        UserAPI userAPI = Url.getInstance().create(UserAPI.class);
        Call<SignUpResponse> SignUpCall = userAPI.registeruser(users);

        SignUpCall.enqueue(new Callback<SignUpResponse>(){
            @Override
            public void onResponse(Call<SignUpResponse>call, Response<SignUpResponse> response)
            {
               if (!response.isSuccessful())
               {
                   Toast.makeText(SignupActivity.this,"Code"+ response.code(), Toast.LENGTH_SHORT).show();
                   return;
               }
                Toast.makeText(SignupActivity.this, "Registered", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<SignUpResponse> call, Throwable t)
            {
                Toast.makeText(SignupActivity.this, "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
