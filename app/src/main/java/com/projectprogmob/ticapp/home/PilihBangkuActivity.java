package com.projectprogmob.ticapp.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.projectprogmob.ticapp.R;

public class PilihBangkuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_bangku);

        ImageView backDetail = findViewById(R.id.ic_back_detail);
        backDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PilihBangkuActivity.this, HomeActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}