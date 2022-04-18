package com.projectprogmob.ticapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.projectprogmob.ticapp.R;
import com.projectprogmob.ticapp.home.DashboardFragment;
import com.projectprogmob.ticapp.home.HomeActivity;

public class SignInActivity extends AppCompatActivity {
    DatabaseReference mDatabase = FirebaseDatabase.getInstance("https://ticappproject-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_activity);

        final EditText etUsername = findViewById(R.id.et_username);
        final EditText etPassword = findViewById(R.id.et_password);

        Button btnSignin = findViewById(R.id.btn_signin);
        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String UsernameTxt = etUsername.getText().toString();
                final String PasswordTxt = etPassword.getText().toString();

                if(UsernameTxt.isEmpty() || PasswordTxt.isEmpty()){
                    Toast.makeText(SignInActivity.this, "Please enter your username or password", Toast.LENGTH_SHORT).show();
                }else{
                    mDatabase.child("User").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.hasChild(UsernameTxt)){
                                final String getPassword = dataSnapshot.child(UsernameTxt).child("password").getValue(String.class);
                                if(getPassword.equals(PasswordTxt)){
                                    Toast.makeText(SignInActivity.this, "Successfully Logged in", Toast.LENGTH_SHORT).show();
                                    Intent toHome = new Intent(SignInActivity.this, HomeActivity.class);
                                    startActivity(toHome);
                                }else{
                                    Toast.makeText(SignInActivity.this,"Your Password is incorrect", Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                Toast.makeText(SignInActivity.this,"Your Username do not match any account",Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
            }
        });

        Button btnSignup = findViewById(R.id.btn_signup);
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toSignUp = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(toSignUp);
            }
        });
    }
}
