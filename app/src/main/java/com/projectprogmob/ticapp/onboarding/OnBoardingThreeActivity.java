package com.projectprogmob.ticapp.onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.projectprogmob.ticapp.R;
import com.projectprogmob.ticapp.SignInActivity;

public class OnBoardingThreeActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onboarding_three_activity);

        Button btnOnBoardingThree = findViewById(R.id.btn_obThree);
        btnOnBoardingThree.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_obThree){
            finishAffinity();

            Intent moveSignin = new Intent(OnBoardingThreeActivity.this, SignInActivity.class);
            startActivity(moveSignin);
        }
    }
}