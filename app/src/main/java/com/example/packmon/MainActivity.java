package com.example.packmon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.packmon.Adapter.PackmonAdapter;
import com.example.packmon.Model.Pokmen;
import com.example.packmon.ViewModel.PackmenoViewModel;
import com.example.packmon.databinding.ActivityMainBinding;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
private PackmenoViewModel viewModel;
private PackmonAdapter adapter;
   static int[] FaveAdded;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        adapter =new PackmonAdapter(this);
        binding.Rv.setAdapter(adapter);
        setupSwipe();
        binding.gtofv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,FaverotPage.class));
                finish();
            }
        });
        viewModel = new ViewModelProvider(this).get(PackmenoViewModel.class);
        viewModel.getPackmoens();

        viewModel.getPokmenList().observe(this, new Observer<ArrayList<Pokmen>>() {
            @Override
            public void onChanged(ArrayList<Pokmen> pokmen) {
                adapter.setPokmenlist(pokmen);
                FaveAdded = new int[adapter.getItemCount()];
            }
        });

    }

    private void setupSwipe()
    {
        ItemTouchHelper.SimpleCallback callback = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int SwipedPokmenPostion=viewHolder.getAdapterPosition();
               if (FaveAdded[SwipedPokmenPostion]!=1)
               {
                   FaveAdded[SwipedPokmenPostion]=1;
                   Pokmen pokmen = adapter.getPokmenFromPesiont(SwipedPokmenPostion);
                   viewModel.insertPackmones(pokmen);
                   adapter.notifyDataSetChanged();

                   Toast.makeText(MainActivity.this, "Added to Faverot", Toast.LENGTH_SHORT).show();
               }
               else {
                   adapter.notifyDataSetChanged();
                   Toast.makeText(MainActivity.this, "This Item hase been Added", Toast.LENGTH_SHORT).show();
               }

            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(binding.Rv);
    }
}