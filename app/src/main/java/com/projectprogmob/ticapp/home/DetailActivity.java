package com.projectprogmob.ticapp.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.projectprogmob.ticapp.R;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent i = getIntent();
        String title = i.getStringExtra("title");
        String genre = i.getStringExtra("genre");
        String rate = i.getStringExtra("rate");
        String poster = i.getStringExtra("poster");
        String desc = i.getStringExtra("desc");

        TextView tvTitle = findViewById(R.id.tv_title);
        tvTitle.setText(title);

        TextView tvGenre = findViewById(R.id.tv_genre);
        tvGenre.setText(genre);

        TextView tvRate = findViewById(R.id.tv_rate);
        tvRate.setText(rate);

        TextView tvDesc = findViewById(R.id.tv_desc);
        tvDesc.setText(desc);

        ImageView ivPoster = findViewById(R.id.iv_poster);
        Glide.with(this)
                .load(poster)
                .into(ivPoster);
        ImageView ivBack = findViewById(R.id.iv_back);

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toHome = new Intent(DetailActivity.this, HomeActivity.class);
                startActivity(toHome);
            }
        });

    }
}