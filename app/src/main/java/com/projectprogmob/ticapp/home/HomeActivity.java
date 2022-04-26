package com.projectprogmob.ticapp.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.projectprogmob.ticapp.R;

public class HomeActivity extends AppCompatActivity {
    TextView tvUsername;
    public static String fullnameTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        Intent i = getIntent();
        fullnameTxt = i.getStringExtra("fullname");
        tvUsername = findViewById(R.id.tv_nama);

        DashboardFragment fragmentHome = new DashboardFragment();
        replaceFragment(fragmentHome);

        ImageView menu2 = findViewById(R.id.iv_menu2);
        ImageView menu3 = findViewById(R.id.iv_menu3);
        ImageView menu1 = findViewById(R.id.iv_menu1);

        Intent intent =getIntent();
        menu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new DashboardFragment());
                menu1.setImageResource(R.drawable.ic_home_active);
                menu2.setImageResource(R.drawable.ic_tiket);
                menu3.setImageResource(R.drawable.ic_profile);
            }
        });


        menu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new TicketFragment());
                menu1.setImageResource(R.drawable.ic_home);
                menu2.setImageResource(R.drawable.ic_tiket_active);
                menu3.setImageResource(R.drawable.ic_profile);
            }
        });


        menu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new ProfileFragment());
                menu1.setImageResource(R.drawable.ic_home);
                menu2.setImageResource(R.drawable.ic_tiket);
                menu3.setImageResource(R.drawable.ic_profile_active);
            }
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.layout_frame, fragment);
        fragmentTransaction.commit();
    }

}