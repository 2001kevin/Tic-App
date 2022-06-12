package com.projectprogmob.ticapp.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.projectprogmob.ticapp.R;

import java.util.ArrayList;

public class PilihBangkuActivity extends AppCompatActivity {

    ImageView A1,A2,A3,A4,B1,B2,B3,B4,C1,C2,C3,C4,D1,D2,D3,D4;
    //Boolean statusA3 = false;
    Boolean statusA1 = false;
    Boolean statusA2 = false;
    Boolean statusA3 = false;
    Boolean statusA4 = false;
    Boolean statusB1 = false;
    Boolean statusB2 = false;
    Boolean statusB3 = false;
    Boolean statusB4 = false;
    Boolean statusC1 = false;
    Boolean statusC2 = false;
    Boolean statusC3 = false;
    Boolean statusC4 = false;
    Boolean statusD1 = false;
    Boolean statusD2 = false;
    Boolean statusD3 = false;
    Boolean statusD4 = false;
    Button btnHome;
    int total;
    ArrayList<Checkout> list;
    Checkout data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_bangku);



        A1 = findViewById(R.id.a1);
        A2 = findViewById(R.id.a2);
        A3 = findViewById(R.id.a3);
        A4 = findViewById(R.id.a4);
        B1 = findViewById(R.id.b1);
        B2 = findViewById(R.id.b2);
        B3 = findViewById(R.id.b3);
        B4 = findViewById(R.id.b4);
        C1 = findViewById(R.id.c1);
        C2 = findViewById(R.id.c2);
        C3 = findViewById(R.id.c3);
        C4 = findViewById(R.id.c4);
        D1 = findViewById(R.id.d1);
        D2 = findViewById(R.id.d2);
        D3 = findViewById(R.id.d3);
        D4 = findViewById(R.id.d4);

        btnHome = findViewById(R.id.btn_home);

        Intent i = getIntent();
        String judul = i.getStringExtra("title");
        String poster = i.getStringExtra("poster");
        String rating = i.getStringExtra("rating");
        String genre = i.getStringExtra("genre");
        TextView tvKursi = findViewById(R.id.tv_kursi);

        tvKursi.setText(judul);
        ImageView backDetail = findViewById(R.id.ic_back_detail);

        list = new ArrayList<>();
        backDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PilihBangkuActivity.this, HomeActivity.class);
                startActivity(i);
                finish();
            }
        });
        A1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(statusA1){
                    A1.setImageResource(R.drawable.ic_rectangle_empty);
                    statusA1 = false;
                    total -= 1;
                    beliTiket(total);

                    data = new Checkout("A1", "70000");
                    list.remove(data);
                }else{ A1.setImageResource(R.drawable.ic_rectangle_selected);
                    statusA1 = true;
                    total +=1;
                    beliTiket(total);

                    data = new Checkout("A1", "70000");
                    list.add(data);
                }
            }
        });
        A2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(statusA2){
                    A2.setImageResource(R.drawable.ic_rectangle_empty);
                    statusA2 = false;
                    total -= 1;
                    beliTiket(total);

                    data = new Checkout("A2", "70000");
                    list.remove(data);
                }else{ A2.setImageResource(R.drawable.ic_rectangle_selected);
                    statusA2 = true;
                    total +=1;
                    beliTiket(total);

                    data = new Checkout("A2", "70000");
                    list.add(data);
                }
            }
        });
        A3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(statusA3){
                    A3.setImageResource(R.drawable.ic_rectangle_empty);
                    statusA3 = false;
                    total -= 1;
                    beliTiket(total);

                    data = new Checkout("A3", "70000");
                    list.remove(data);
                }else{ A3.setImageResource(R.drawable.ic_rectangle_selected);
                    statusA3 = true;
                    total +=1;
                    beliTiket(total);

                    //datalist.clear();
                    data = new Checkout("A3", "70000");
                    list.add(data);
                }
            }
        });
        A4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(statusA4){
                    A4.setImageResource(R.drawable.ic_rectangle_empty);
                    statusA4 = false;
                    total -= 1;
                    beliTiket(total);

                    data = new Checkout("A4", "70000");
                    list.remove(data);
                }else{ A4.setImageResource(R.drawable.ic_rectangle_selected);
                    statusA4 = true;
                    total +=1;
                    beliTiket(total);

                    data = new Checkout("A4", "70000");
                    list.add(data);

                }
            }
        });
        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(statusB1){
                    B1.setImageResource(R.drawable.ic_rectangle_empty);
                    statusB1 = false;
                    total -= 1;
                    beliTiket(total);

                    data = new Checkout("B1", "70000");
                    list.remove(data);
                }else{ B1.setImageResource(R.drawable.ic_rectangle_selected);
                    statusB1 = true;
                    total +=1;
                    beliTiket(total);

                    data = new Checkout("B1", "70000");
                    list.add(data);

                }
            }
        });
        B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(statusB2){
                    B2.setImageResource(R.drawable.ic_rectangle_empty);
                    statusB2 = false;
                    total -= 1;
                    beliTiket(total);

                    data = new Checkout("B2", "70000");
                    list.remove(data);
                }else{ B2.setImageResource(R.drawable.ic_rectangle_selected);
                    statusB2 = true;
                    total +=1;
                    beliTiket(total);

                    data = new Checkout("B2", "70000");
                    list.add(data);

                }
            }
        });
        B3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(statusB3){
                    B3.setImageResource(R.drawable.ic_rectangle_empty);
                    statusB3 = false;
                    total -= 1;
                    beliTiket(total);

                    data = new Checkout("B3", "70000");
                    list.remove(data);
                }else{ B3.setImageResource(R.drawable.ic_rectangle_selected);
                    statusB3 = true;
                    total +=1;
                    beliTiket(total);

                    data = new Checkout("B3", "70000");
                    list.add(data);

                }
            }
        });
        B4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(statusB4){
                    B4.setImageResource(R.drawable.ic_rectangle_empty);
                    statusB4 = false;
                    total -= 1;
                    beliTiket(total);

                    data = new Checkout("B4", "70000");
                    list.remove(data);
                }else{ B4.setImageResource(R.drawable.ic_rectangle_selected);
                    statusB4 = true;
                    total +=1;
                    beliTiket(total);

                    data = new Checkout("B4", "70000");
                    list.add(data);

                }
            }
        });
        C1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(statusC1){
                    C1.setImageResource(R.drawable.ic_rectangle_empty);
                    statusC1 = false;
                    total -= 1;
                    beliTiket(total);

                    data = new Checkout("C1", "70000");
                    list.remove(data);
                }else{ C1.setImageResource(R.drawable.ic_rectangle_selected);
                    statusC1 = true;
                    total +=1;
                    beliTiket(total);

                    data = new Checkout("C1", "70000");
                    list.add(data);

                }
            }
        });
        C2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(statusC2){
                    C2.setImageResource(R.drawable.ic_rectangle_empty);
                    statusC2 = false;
                    total -= 1;
                    beliTiket(total);

                    data = new Checkout("C2", "70000");
                    list.remove(data);
                }else{ C2.setImageResource(R.drawable.ic_rectangle_selected);
                    statusC2 = true;
                    total +=1;
                    beliTiket(total);

                    data = new Checkout("C2", "70000");
                    list.add(data);

                }
            }
        });
        C3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(statusC3){
                    C3.setImageResource(R.drawable.ic_rectangle_empty);
                    statusC3 = false;
                    total -= 1;
                    beliTiket(total);

                    data = new Checkout("C3", "70000");
                    list.remove(data);
                }else{ C3.setImageResource(R.drawable.ic_rectangle_selected);
                    statusC3 = true;
                    total +=1;
                    beliTiket(total);

                    data = new Checkout("C3", "70000");
                    list.add(data);

                }
            }
        });
        C4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(statusC4){
                    C4.setImageResource(R.drawable.ic_rectangle_empty);
                    statusC4 = false;
                    total -= 1;
                    beliTiket(total);

                    data = new Checkout("C4", "70000");
                    list.remove(data);
                }else{ C4.setImageResource(R.drawable.ic_rectangle_selected);
                    statusC4 = true;
                    total +=1;
                    beliTiket(total);

                    data = new Checkout("C4", "70000");
                    list.add(data);

                }
            }
        });
        D1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(statusD1){
                    D1.setImageResource(R.drawable.ic_rectangle_empty);
                    statusD1 = false;
                    total -= 1;
                    beliTiket(total);

                    data = new Checkout("D1", "70000");
                    list.remove(data);
                }else{ D1.setImageResource(R.drawable.ic_rectangle_selected);
                    statusD1 = true;
                    total +=1;
                    beliTiket(total);

                    data = new Checkout("D1", "70000");
                    list.add(data);

                }
            }
        });
        D2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(statusD2){
                    D2.setImageResource(R.drawable.ic_rectangle_empty);
                    statusD2 = false;
                    total -= 1;
                    beliTiket(total);

                    data = new Checkout("D2", "70000");
                    list.remove(data);
                }else{ D2.setImageResource(R.drawable.ic_rectangle_selected);
                    statusD2 = true;
                    total +=1;
                    beliTiket(total);

                    data = new Checkout("D2", "70000");
                    list.add(data);

                }
            }
        });
        D3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(statusD3){
                    D3.setImageResource(R.drawable.ic_rectangle_empty);
                    statusD3 = false;
                    total -= 1;
                    beliTiket(total);

                    data = new Checkout("D3", "70000");
                    list.remove(data);
                }else{ D3.setImageResource(R.drawable.ic_rectangle_selected);
                    statusD3 = true;
                    total +=1;
                    beliTiket(total);

                    data = new Checkout("D3", "70000");
                    list.add(data);

                }
            }
        });
        D4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(statusD4){
                    D4.setImageResource(R.drawable.ic_rectangle_empty);
                    statusD4 = false;
                    total -= 1;
                    beliTiket(total);

                    data = new Checkout("D4", "70000");
                    list.remove(data);
                }else{ D4.setImageResource(R.drawable.ic_rectangle_selected);
                    statusD4 = true;
                    total +=1;
                    beliTiket(total);

                    data = new Checkout("D4", "70000");
                    list.add(data);

                }
            }
        });
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toCheckout = new Intent(PilihBangkuActivity.this, CheckoutActivity.class);
                toCheckout.putExtra("Checkout", list);
                toCheckout.putExtra("judul", judul);
                toCheckout.putExtra("poster", poster);
                toCheckout.putExtra("rating", rating);
                toCheckout.putExtra("genre", genre);
                startActivity(toCheckout);
            }
        });
    }

    private void beliTiket(int total) {
        if(total == 0){
            btnHome.setText("Beli Tiket");
            btnHome.setVisibility(View.INVISIBLE);
        }else{
            btnHome.setText("Beli Tiket ("+total+")");
            btnHome.setVisibility(View.VISIBLE);
        }
    }
}