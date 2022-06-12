package com.projectprogmob.ticapp.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.projectprogmob.ticapp.R;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class CheckoutActivity extends AppCompatActivity {
    int total = 0;
    ArrayList<Checkout> list;
    int size;
//    Checkout data;
//    String kursi;
//    RecyclerView rcCheckout;
//    CheckoutAdapter checkoutAdapter;
    TextView []tv;
    TextView []tvPrice;
    Button btnBayar;
    Button btnBatal;
    //TextView Harga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        TextView tvHarga = findViewById(R.id.tv_harga);
        tv=new TextView[16];
        tv[0]= findViewById(R.id.tv_kursi1);
        tv[1]= findViewById(R.id.tv_kursi2);
        tv[2]= findViewById(R.id.tv_kursi3);
        tv[3]= findViewById(R.id.tv_kursi4);
        tv[4]= findViewById(R.id.tv_kursi5);
        tv[5]= findViewById(R.id.tv_kursi6);
        tv[6]= findViewById(R.id.tv_kursi7);
        tv[7]= findViewById(R.id.tv_kursi8);
        tv[8]= findViewById(R.id.tv_kursi9);
        tv[9]= findViewById(R.id.tv_kursi10);
        tv[10]= findViewById(R.id.tv_kursi11);
        tv[11]= findViewById(R.id.tv_kursi12);
        tv[12]= findViewById(R.id.tv_kursi13);
        tv[13]= findViewById(R.id.tv_kursi14);
        tv[14]= findViewById(R.id.tv_kursi15);
        tv[15]= findViewById(R.id.tv_kursi16);

        tvPrice=new TextView[16];
        tvPrice[0]= findViewById(R.id.tv_hargaTiket1);
        tvPrice[1]= findViewById(R.id.tv_hargaTiket2);
        tvPrice[2]= findViewById(R.id.tv_hargaTiket3);
        tvPrice[3]= findViewById(R.id.tv_hargaTiket4);
        tvPrice[4]= findViewById(R.id.tv_hargaTiket5);
        tvPrice[5]= findViewById(R.id.tv_hargaTiket6);
        tvPrice[6]= findViewById(R.id.tv_hargaTiket7);
        tvPrice[7]= findViewById(R.id.tv_hargaTiket8);
        tvPrice[8]= findViewById(R.id.tv_hargaTiket9);
        tvPrice[9]= findViewById(R.id.tv_hargaTiket10);
        tvPrice[10]= findViewById(R.id.tv_hargaTiket11);
        tvPrice[11]= findViewById(R.id.tv_hargaTiket12);
        tvPrice[12]= findViewById(R.id.tv_hargaTiket13);
        tvPrice[13]= findViewById(R.id.tv_hargaTiket14);
        tvPrice[14]= findViewById(R.id.tv_hargaTiket15);
        tvPrice[15]= findViewById(R.id.tv_hargaTiket16);

        btnBatal = findViewById(R.id.btn_home);
        btnBayar = findViewById(R.id.btn_bayar);

        Intent intent = this.getIntent();
        list = (ArrayList<Checkout>) intent.getSerializableExtra("Checkout");
        String judul = intent.getStringExtra("judul");
        String poster = intent.getStringExtra("poster");
        String rating = intent.getStringExtra("rating");
        String genre = intent.getStringExtra("genre");
        size = list.size();
        System.out.println(size);
        for (int a = 0; a < size; a++) {
            //String listHarga = list.get(a).getHarga();
            total = total + Integer.parseInt(list.get(a).getHarga());
        }

        tvHarga.setText("IDR "+String.valueOf(total));
        String Total = String.valueOf(total);
        String Size = String.valueOf(size);

//        list.add(new Checkout("Total Harga : ", String.valueOf(total)));
//        System.out.println(list);
        for (int b = 0; b < size; b++) {
            tv[b].setVisibility(View.VISIBLE);
            tvPrice[b].setVisibility(View.VISIBLE);
            tv[b].setText("Seat No. "+list.get(b).getKursi());
            tvPrice[b].setText("IDR "+list.get(b).getHarga());
        }
        btnBatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toHome = new Intent(CheckoutActivity.this, HomeActivity.class);
                startActivity(toHome);
            }
        });
        btnBayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toBayar = new Intent(CheckoutActivity.this, CheckoutSuccessActivity.class);
                toBayar.putExtra("Checkout", list);
                toBayar.putExtra("judul", judul);
                toBayar.putExtra("poster", poster);
                toBayar.putExtra("rating", rating);
                toBayar.putExtra("genre", genre);
                toBayar.putExtra("total", Total);
                toBayar.putExtra("size", Size);
                startActivity(toBayar);
            }
        });




//        rcCheckout = findViewById(R.id.rc_checkout);
//        rcCheckout.setHasFixedSize(false);
//
//        rcCheckout.setLayoutManager(new LinearLayoutManager(this));
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        rcCheckout.setLayoutManager(layoutManager);
//        list = new ArrayList<>();
//        //System.out.println(list);
//        checkoutAdapter = new CheckoutAdapter(list);
//        rcCheckout.setAdapter(checkoutAdapter);
    }
}