package com.projectprogmob.ticapp.onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.projectprogmob.ticapp.R;
import com.projectprogmob.ticapp.SignInActivity;

public class OnBoardingOneActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onboarding_one_activity);

        Button btnOnBoardingLanjut = findViewById(R.id.btn_lanjut_obOne);
        btnOnBoardingLanjut.setOnClickListener(this);

        Button btnOnBoardingSkip = findViewById(R.id.btn_obOne);
        btnOnBoardingSkip.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_lanjut_obOne){
            Intent moveObtwo = new Intent(OnBoardingOneActivity.this, OnBoardingTwoActivity.class);
            startActivity(moveObtwo);
        }else if(view.getId() == R.id.btn_obOne){
            finishAffinity();

            Intent moveSignin = new Intent(OnBoardingOneActivity.this, SignInActivity.class );
            startActivity(moveSignin);
        }
    }
}