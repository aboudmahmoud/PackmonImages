package com.example.packmon.Adapter;

import android.content.Context;
import android.graphics.Picture;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.packmon.Model.Pokmen;
import com.example.packmon.R;
import com.example.packmon.databinding.PackmoenItemBinding;

import java.util.ArrayList;

public class PackmonAdapter extends RecyclerView.Adapter<PackmonAdapter.PockmonHolder> {

    ArrayList<Pokmen> pokmenlist = new ArrayList<>();
private Context context;

    public PackmonAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Pokmen> getPokmenlist() {
        return pokmenlist;
    }

    public void setPokmenlist(ArrayList<Pokmen> pokmenlist) {
        this.pokmenlist = pokmenlist;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PockmonHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PockmonHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.packmoen_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PockmonHolder holder, int position) {
Pokmen pokmen = pokmenlist.get(position);
        holder.bind(pokmen);
    }

    @Override
    public int getItemCount() {
        return pokmenlist.size();
    }

    public Pokmen getPokmenFromPesiont(int postion)
    {
        /*Pokmen pokmen = pokmenlist.get(postion);
        return pokmen;*/
        return pokmenlist.get(postion);
    }
    class PockmonHolder extends RecyclerView.ViewHolder {
        private PackmoenItemBinding binding;

        public PockmonHolder(@NonNull View itemView) {
            super(itemView);
            binding = PackmoenItemBinding.bind(itemView);
        }

        void bind(Pokmen pokmen) {
            binding.PomenNameTV.setText(pokmen.getName());
            Glide.with(context).load(pokmen.getUrl()).into(binding.PackmeonImageIV);






        }
    }
}
