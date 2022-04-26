package com.projectprogmob.ticapp.home;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.projectprogmob.ticapp.R;

import java.util.ArrayList;

public class NowPlayingAdapter extends RecyclerView.Adapter<NowPlayingAdapter.MyViewHolder> {

    Context context;
    ArrayList<Film> list;

    public NowPlayingAdapter(Context context, ArrayList<Film> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_item_now_playing,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Film film = list.get(position);
        holder.tvTitle.setText(film.getJudul());
        holder.tvGenre.setText(film.getGenre());
        holder.tvRate.setText(film.getRating());

        Glide.with(context)
                .load(film.poster)
                .into(holder.ivImage);
        holder.poster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toDetail = new Intent(context, DetailActivity.class);
                toDetail.putExtra("title", film.getJudul() );
                toDetail.putExtra("genre", film.getGenre() );
                toDetail.putExtra("rate", film.getRating() );
                toDetail.putExtra("poster", film.getPoster());
                toDetail.putExtra("desc", film.getDesc());
                context.startActivity(toDetail);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvTitle, tvGenre, tvRate;
        ImageView ivImage;
        CardView poster;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
                tvTitle = itemView.findViewById(R.id.tv_title);
                tvGenre = itemView.findViewById(R.id.tv_genre);
                tvRate = itemView.findViewById(R.id.tv_rate);
                ivImage = itemView.findViewById(R.id.iv_poster_image);
                poster = itemView.findViewById(R.id.cv_poster);


        }
    }
}
