package com.example.mobdev3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        FirstFragment firstFragment = FirstFragment.newInstance("","");
        fragmentTransaction.replace(R.id.fragment_placeholder,firstFragment).addToBackStack(null).commit();
    }
}