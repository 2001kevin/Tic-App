package com.projectprogmob.ticapp.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.projectprogmob.ticapp.R;

import java.util.ArrayList;

public class TicketActivity extends AppCompatActivity {
    TextView tvTittle, tvRate, tvGenre, tvHargaTotal, tvItems;
    ImageView ivPoster, ivClose;
    ArrayList<Checkout> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);

        tvTittle = findViewById(R.id.tv_title);
        tvRate = findViewById(R.id.tv_rate);
        tvGenre = findViewById(R.id.tv_genre);
        ivPoster = findViewById(R.id.iv_poster_image);
        ivClose = findViewById(R.id.iv_close);
        tvHargaTotal = findViewById(R.id.tv_hargaTotal);
        tvItems = findViewById(R.id.tv_items);

        Intent i = getIntent();
        list = (ArrayList<Checkout>) i.getSerializableExtra("Checkout");
        String judul = i.getStringExtra("judul");
        String genre = i.getStringExtra("genre");
        String rate = i.getStringExtra("rating");
        String poster = i.getStringExtra("poster");
        String items = i.getStringExtra("size");
        String totalHarga = i.getStringExtra("total");

        tvTittle.setText(judul);
        tvRate.setText(rate);
        tvGenre.setText(genre);
        Glide.with(this)
                .load(poster)
                .into(ivPoster);
        tvItems.setText(items+" pcs");
        tvHargaTotal.setText("IDR "+totalHarga);
        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toHome = new Intent(TicketActivity.this, HomeActivity.class);
                startActivity(toHome);
            }
        });

    }
}