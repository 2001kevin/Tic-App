package com.projectprogmob.ticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_activity);

        ImageView back = findViewById(R.id.iv_back);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.iv_back){
            Intent toSignin = new Intent(SignUpActivity.this, SignInActivity.class);
            startActivity(toSignin);
        }
    }
}