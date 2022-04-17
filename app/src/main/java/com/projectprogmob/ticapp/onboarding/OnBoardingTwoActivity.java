package com.projectprogmob.ticapp.onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.projectprogmob.ticapp.R;
import com.projectprogmob.ticapp.SignInActivity;

public class OnBoardingTwoActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onboarding_two_activity);

        Button btnOnBoardingLanjutTwo = findViewById(R.id.btn_lanjut_obTwo);
        btnOnBoardingLanjutTwo.setOnClickListener(this);

        Button btnOnBoardingTwoSkip = findViewById(R.id.btn_obTwo);
        btnOnBoardingTwoSkip.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_lanjut_obTwo){
            Intent moveObThree = new Intent(OnBoardingTwoActivity.this, OnBoardingThreeActivity.class);
            startActivity(moveObThree);
        }else if(view.getId() == R.id.btn_obTwo){
            Intent moveSignin = new Intent(OnBoardingTwoActivity.this, SignInActivity.class);
            startActivity(moveSignin);
        }
    }
}