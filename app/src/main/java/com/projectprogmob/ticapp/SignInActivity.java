package com.projectprogmob.ticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.projectprogmob.ticapp.R;
import com.projectprogmob.ticapp.home.DashboardFragment;
import com.projectprogmob.ticapp.home.HomeActivity;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etUsername;
    EditText etPassword;

    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_activity);

        mDatabase = FirebaseDatabase.getInstance().getReference("User");

        etUsername = (EditText) findViewById(R.id.et_username);
        etPassword = (EditText) findViewById(R.id.et_password);

        Button btnSignin = findViewById(R.id.btn_signin);
        btnSignin.setOnClickListener(this);

        Button btnSignup = findViewById(R.id.btn_signup);
        btnSignup.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_signin){
            String usernameValue = etUsername.getText().toString();
            String pwValue = etPassword.getText().toString();

            if(usernameValue.equals("")){
                etUsername.setError("Tolong masukan username anda dengan benar!");
                etUsername.requestFocus();
            }else if(pwValue.equals("")){
                etPassword.setError("Tolong masukan password anda dengan benar!");
                etPassword.requestFocus();
            }else{
                pushLogin(usernameValue,pwValue );
            }

        }else if(view.getId() == R.id.btn_signup){
            Intent moveToSignup = new Intent(SignInActivity.this, SignUpActivity.class);
            startActivity(moveToSignup);
        }
    }

    private void pushLogin(String usernameValue, String pwValue) {
        mDatabase.child(usernameValue).addValueEventListener( ValueEventListener{
            protected void onDataChange Object dataSnapshot;
            (dataSnapshot: DataSnapshot){
               String user = dataSnapshot.getClass(User.class);
            }
        })
    }
}