package com.projectprogmob.ticapp.home;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

public class TicketFragment extends Fragment {

    View view;
    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    ComingSoonAdapter comingSoonAdapter;
    ArrayList<Film> list;
    TextView tvTotal;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_ticket, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        databaseReference = FirebaseDatabase.getInstance("https://ticappproject-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Film");

        tvTotal = view.findViewById(R.id.tv_total);

        recyclerView = view.findViewById(R.id.rc_tiket);
        recyclerView.setHasFixedSize(false);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        list = new ArrayList<>();
        comingSoonAdapter = new ComingSoonAdapter(getContext(), list);
        recyclerView.setAdapter(comingSoonAdapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    Film film = dataSnapshot1.getValue(Film.class);
                    list.add(film);
                }
                comingSoonAdapter.notifyDataSetChanged();
                tvTotal.setText( "There is " +list.size()+ " Movies");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}