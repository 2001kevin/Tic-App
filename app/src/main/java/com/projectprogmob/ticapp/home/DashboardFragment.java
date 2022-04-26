package com.projectprogmob.ticapp.home;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.preference.Preference;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.projectprogmob.ticapp.R;

import java.util.ArrayList;
import java.util.Objects;

public class DashboardFragment extends Fragment {
    View view;
    TextView tvUsername;
    RecyclerView recyclerView;
    RecyclerView recyclerView2;
    DatabaseReference databaseReference;
    NowPlayingAdapter nowPlayingAdapter;
    ComingSoonAdapter comingSoonAdapter;
    ArrayList<Film> list;

    //SharedPreferences preferences;
    //Context c = getActivity();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_dashboard, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvUsername = view.findViewById(R.id.tv_nama);
        SharedPreferences preferences = this.getActivity().getSharedPreferences("shared_pref", Context.MODE_PRIVATE);
        String fullname = preferences.getString("fullname",null);
        tvUsername.setText(fullname);

        recyclerView = view.findViewById(R.id.rv_nowplaying);
        recyclerView2 = view.findViewById(R.id.rv_comingsoon);
        databaseReference = FirebaseDatabase.getInstance("https://ticappproject-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Film");
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false);
        recyclerView2.setLayoutManager(layoutManager2);


        list = new ArrayList<>();
        list = new ArrayList<>();
        nowPlayingAdapter = new NowPlayingAdapter(getContext(), list);
        recyclerView.setAdapter(nowPlayingAdapter);
        comingSoonAdapter = new ComingSoonAdapter(getContext(), list);
        recyclerView2.setAdapter(comingSoonAdapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    Film film = dataSnapshot1.getValue(Film.class);
                    list.add(film);
                }
                nowPlayingAdapter.notifyDataSetChanged();
                comingSoonAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}
