package com.projectprogmob.ticapp.home;

import static android.content.Intent.ACTION_DIAL;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.projectprogmob.ticapp.R;

public class ProfileFragment extends Fragment {
    View view;

    TextView tvFullname;
    TextView tvEmail;
    TextView tvHelp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_profile, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvFullname = view.findViewById(R.id.tv_nama);
        tvEmail = view.findViewById(R.id.tv_email);
        tvHelp = view.findViewById(R.id.tv_help);

        SharedPreferences preferences = this.getContext().getSharedPreferences("shared_pref", Context.MODE_PRIVATE);
        String fullname = preferences.getString("fullname", null);
        String email = preferences.getString("email", null);

        tvFullname.setText(fullname);
        tvEmail.setText(email);

        tvHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = "0822094239";
                Intent callIntent = new Intent(ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:" + number));//change the number
                startActivity(callIntent);
            }
        });


    }
}