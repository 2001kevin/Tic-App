package com.projectprogmob.ticapp.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.projectprogmob.ticapp.R;

import java.util.ArrayList;

public class ComingSoonAdapter extends RecyclerView.Adapter<ComingSoonAdapter.MyViewHolder> {

    Context context;
    ArrayList<Film> list;

    public ComingSoonAdapter(Context context, ArrayList<Film> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_item_coming_soon,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ComingSoonAdapter.MyViewHolder holder, int position) {
        Film film = list.get(position);
        holder.tvTitle.setText(film.getJudul());
        holder.tvGenre.setText(film.getGenre());
        holder.tvRate.setText(film.getRating());

        Glide.with(context)
                .load(film.poster)
                .into(holder.ivImage);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvTitle, tvGenre, tvRate;
        ImageView ivImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvGenre = itemView.findViewById(R.id.tv_genre);
            tvRate = itemView.findViewById(R.id.tv_rate);
            ivImage = itemView.findViewById(R.id.iv_poster_image);

        }
    }

}
