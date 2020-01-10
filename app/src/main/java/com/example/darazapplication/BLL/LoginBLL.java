package com.example.darazapplication.BLL;

import com.example.darazapplication.API.UserAPI;
import com.example.darazapplication.ServerResponse.SignUpResponse;
import com.example.darazapplication.URL.Url;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class LoginBLL {

    boolean isSuccess = false;

    public boolean checkUser(String username, String password)
    {
        UserAPI usersAPI = Url.getInstance().create(UserAPI.class);
        Call<SignUpResponse> userCall = usersAPI.checkUser(username,password);

        try {
            Response<SignUpResponse> loginResponse = userCall.execute();
            if (loginResponse.isSuccessful() && loginResponse.body().getStatus().equals("Login Success")) {
                Url.token += loginResponse.body().getToken();

                // Url.Cookie = imageResponseResponse.headers().get("Set-Cookie");

                isSuccess = true;
            }
        }
            catch(IOException e)
            {
                e.printStackTrace();
            }
            return isSuccess;

        }


}
