package com.example.darazapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.darazapplication.BLL.LoginBLL;
import com.example.darazapplication.StrictMode.StrictModeClass;

public class PasswordFragment extends Fragment {
    private Button btnuserlogin;
    private EditText etusername, etpassword;

    public PasswordFragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_password, container, false);
        btnuserlogin = root.findViewById(R.id.btnuserlogin);
        etusername = root.findViewById(R.id.txtusername);
        etpassword = root.findViewById(R.id.txtpassword);

        btnuserlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
        return root;


    }

    private void login()
    {
        String username = etusername.getText().toString();
        String password = etpassword.getText().toString();

        LoginBLL loginBLL = new LoginBLL();

        StrictModeClass.StrictMode();
        if (loginBLL.checkUser(username,password))
        {
            Intent intent = new Intent(getContext(),SMSFragment.class);
            startActivity(intent);

        }
        else
        {
            Toast.makeText(getContext(),"Either usernam eor passoword is incorrect", Toast.LENGTH_SHORT).show();
            etusername.requestFocus();
        }
    }


}
