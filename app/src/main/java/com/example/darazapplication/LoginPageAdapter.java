package com.example.darazapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class LoginPageAdapter extends FragmentPagerAdapter
{
    private int NoOftabs;

    public LoginPageAdapter(@NonNull FragmentManager fm,int NoOftabs)
    {
        super(fm);
        this.NoOftabs = NoOftabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position)
    {
        switch (position)
        {
            case 0:
                return new PasswordFragment();

            case 1:
                return new SMSFragment();

                default:
                    return null;
        }
    }

    @Override
    public int getItemPosition(@NonNull Object object) { return POSITION_NONE;}


    @Override
    public int getCount(){return NoOftabs;}


}
