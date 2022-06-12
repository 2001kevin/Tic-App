package com.projectprogmob.ticapp.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.drawable.Icon;
import android.media.Image;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.projectprogmob.ticapp.R;

public class HomeActivity extends AppCompatActivity {
    TextView tvUsername;
    public static String fullnameTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

        DashboardFragment fragmentHome = new DashboardFragment();
        replaceFragment(fragmentHome);

        BottomNavigationView mNav = findViewById(R.id.bottomNav);
        mNav.setItemIconTintList(null);
        mNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId()==R.id.home){
                    replaceFragment(new DashboardFragment());
                }else if (item.getItemId()==R.id.ticket){
                    replaceFragment(new TicketFragment());
                }else if(item.getItemId()==R.id.profile){
                    replaceFragment(new ProfileFragment());
                }
                return true;
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