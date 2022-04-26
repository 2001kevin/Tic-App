package com.projectprogmob.ticapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class SignUpActivity extends AppCompatActivity  {

    //membuat objek database reference class ke firebase realtime database
    DatabaseReference mDatabase = FirebaseDatabase.getInstance("https://ticappproject-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_activity);

        final EditText etfullname = findViewById(R.id.etFullname);
        final EditText etusername = findViewById(R.id.etUsername);
        final EditText etemail = findViewById(R.id.etEmail);
        final EditText etphone = findViewById(R.id.etPhone);
        final EditText etpassword = findViewById(R.id.etPassword);
        final EditText etconpassword = findViewById(R.id.etConPassword);

        ImageView back = findViewById(R.id.iv_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toSignin = new Intent(SignUpActivity.this, SignInActivity.class);
                startActivity(toSignin);
            }
        });

        Button btnDaftar = findViewById(R.id.btn_daftar);
        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toLogin = new Intent(SignUpActivity.this, SignInActivity.class);
                toLogin.putExtra("username", etusername.getText().toString());
                toLogin.putExtra("password", etpassword.getText().toString());
                startActivity(toLogin);
                //MENGAMBIL DATA DARI EDIT TEXT KE STRING VARIABLE
                final String fullnametxt = etfullname.getText().toString();
                final String usernametxt = etusername.getText().toString();
                final String emailtxt = etemail.getText().toString();
                final String phonetxt = etphone.getText().toString();
                final String passwordtxt = etpassword.getText().toString();
                final String conpasswordtxt = etconpassword.getText().toString();
                final String noWhiteSpace = "(?=\\s+$)";
                final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                final String passwordpattern = "^" +
                        //"(?=.*[0-9])" +         //at least 1 digit
                        //"(?=.*[a-z])" +         //at least 1 lower case letter
                        //"(?=.*[A-Z])" +         //at least 1 upper case letter
                        "(?=.*[a-zA-Z])" +      //any letter
                        //"(?=.*[@#$%^&+=])" +    //at least 1 special character
                        "(?=\\S+$)" +           //no white spaces
                        ".{4,}" +               //at least 4 characters
                        "$";


                //CEK APAKAH USER MENGISI SEMUA FIELD NYA
                if(fullnametxt.isEmpty() || usernametxt.isEmpty() || emailtxt.isEmpty() || phonetxt.isEmpty() || passwordtxt.isEmpty() || conpasswordtxt.isEmpty()){
                    Toast.makeText(SignUpActivity.this, "Mohon isi semua field!", Toast.LENGTH_SHORT).show();
                }else if(!usernametxt.matches(noWhiteSpace)){
                    Toast.makeText(SignUpActivity.this, "Username Must Be no WhiteSpace", Toast.LENGTH_LONG).show();

                }else if (!emailtxt.matches(emailPattern)){
                    Toast.makeText(SignUpActivity.this, "Invalid Email Address", Toast.LENGTH_LONG).show();
                }else if (!passwordtxt.matches(passwordpattern)){
                    Toast.makeText(SignUpActivity.this, "Password too weak", Toast.LENGTH_LONG).show();
                }
                else if(!passwordtxt.equals(conpasswordtxt)){
                    Toast.makeText(SignUpActivity.this, "Password tidak match", Toast.LENGTH_SHORT).show();
                }else {
                    mDatabase.child("User").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            //cek apakah username sudah dipakai atau tidak
                            if(dataSnapshot.hasChild(usernametxt)){
                                Toast.makeText(SignUpActivity.this, "Username is already registered", Toast.LENGTH_SHORT).show();
                            }else{

                                mDatabase.child("User").child(usernametxt).child("email").setValue(emailtxt);
                                mDatabase.child("User").child(usernametxt).child("fullname").setValue(fullnametxt);
                                mDatabase.child("User").child(usernametxt).child("phone").setValue(phonetxt);
                                mDatabase.child("User").child(usernametxt).child("password").setValue(passwordtxt);

                                Toast.makeText(SignUpActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                }
            }
        });
    }
}



