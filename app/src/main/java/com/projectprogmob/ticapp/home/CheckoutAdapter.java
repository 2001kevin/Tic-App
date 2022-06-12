package com.projectprogmob.ticapp.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.projectprogmob.ticapp.R;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class CheckoutAdapter extends RecyclerView.Adapter<CheckoutAdapter.MyViewHolder> {
    ArrayList<Checkout> list;

    public CheckoutAdapter( ArrayList<Checkout> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_checkout,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CheckoutAdapter.MyViewHolder holder, int position) {
        Locale localeid = new Locale("in", "ID");
        NumberFormat formatRp = NumberFormat.getCurrencyInstance(localeid);

        Checkout checkout = list.get(position);
        holder.tvHarga.setText(formatRp.format(checkout.getHarga()));

        if (checkout.getHarga().startsWith("Total")){
            holder.tvKursi.setText(checkout.getKursi());
            holder.tvKursi.setCompoundDrawables(null, null,null,null);
        }else{
            holder.tvKursi.setText("Seat No. "+checkout.getKursi());
        }
    }

    @Override
    public int getItemCount() { return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvKursi, tvHarga;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvHarga = itemView.findViewById(R.id.tv_harga);
            tvKursi = itemView.findViewById(R.id.tv_kursi);

        }
    }

}
