package com.projectprogmob.ticapp;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.projectprogmob.ticapp.onboarding.OnBoardingOneActivity;


public class SplashScreenActivity extends AppCompatActivity {
    final private int waktu_loading = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen_activity);

        new Handler().postDelayed(() -> {
            Intent OnBoarding = new Intent(SplashScreenActivity.this, OnBoardingOneActivity.class);
            startActivity(OnBoarding);
            finish();
        },waktu_loading);
    }
}