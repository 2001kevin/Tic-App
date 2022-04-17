package com.projectprogmob.ticapp.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.projectprogmob.ticapp.R;

public class DashboardFragment extends Fragment {

    View view;
    String myStr;
    TextView tvUsername;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_dashboard, container, false);
        tvUsername = view.findViewById(R.id.tv_nama);
        Bundle username = getArguments();

        if(username != null){
            myStr = username.getString("Username");
            tvUsername.setText("ssdfsd");
        }
        return view;
    }
}