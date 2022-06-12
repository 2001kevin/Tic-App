package com.projectprogmob.ticapp.home;

import androidx.appcompat.app.AppCompatActivity;
import com.projectprogmob.ticapp.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class CheckoutSuccessActivity extends AppCompatActivity {
    ArrayList<Checkout> list;
    Button btnTiket;
    Button btnHome;
    int total = 0;
    int size;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_success);
        Intent intent = this.getIntent();
        list = (ArrayList<Checkout>) intent.getSerializableExtra("Checkout");
        String judul = intent.getStringExtra("judul");
        String poster = intent.getStringExtra("poster");
        String rating = intent.getStringExtra("rating");
        String genre = intent.getStringExtra("genre");
        size = list.size();
        String Size = String.valueOf(size);

        for (int a = 0; a < size; a++) {
            total = total + Integer.parseInt(list.get(a).getHarga());
        }

        String Total = String.valueOf(total);

        btnTiket = findViewById(R.id.btn_tiket);
        btnHome = findViewById(R.id.btn_home);

        btnTiket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toTiket = new Intent(CheckoutSuccessActivity.this, TicketActivity.class);
                toTiket.putExtra("Checkout", list);
                toTiket.putExtra("judul", judul);
                toTiket.putExtra("poster", poster);
                toTiket.putExtra("rating", rating);
                toTiket.putExtra("genre", genre);
                toTiket.putExtra("total", Total);
                toTiket.putExtra("size", Size);
                startActivity(toTiket);
                
            }
        });
    }
}