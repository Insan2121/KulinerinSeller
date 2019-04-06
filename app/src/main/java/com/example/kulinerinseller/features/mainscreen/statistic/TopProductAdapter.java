package com.example.kulinerinseller.features.mainscreen.statistic;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kulinerinseller.R;
import com.example.kulinerinseller.features.mainscreen.MainScreenActivity;
import com.example.kulinerinseller.models.Product;
import com.example.kulinerinseller.models.Seller;

import java.util.ArrayList;

public class TopProductAdapter extends RecyclerView.Adapter<TopProductAdapter.ViewHolder> {

    private ArrayList<Seller> products;
    private View view;

    public TopProductAdapter(ArrayList<Seller> products) {
        this.products = products;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_top_products, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Seller Product = products.get(position);
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View view;

        public ViewHolder(@NonNull View view) {
            super(view);
            this.view = view;

        }
    }
}