package com.example.packmon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
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
import com.example.packmon.databinding.ActivityFaverotPageBinding;

import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class FaverotPage extends AppCompatActivity {
ActivityFaverotPageBinding binding;
    private PackmenoViewModel viewModel;
    private PackmonAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityFaverotPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        adapter =new PackmonAdapter(this);
        binding.Rv2.setAdapter(adapter);
        setupSwipe();
        binding.gtohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              startActivity(new Intent(FaverotPage.this,MainActivity.class));
                finish();
            }
        });

        viewModel = new ViewModelProvider(this).get(PackmenoViewModel.class);
        viewModel.getFavPackmoens();

        viewModel.getFavList().observe(this, new Observer<List<Pokmen>>() {
            @Override
            public void onChanged(List<Pokmen> pokmen) {
                adapter.setPokmenlist((ArrayList<Pokmen>) pokmen);
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
                Pokmen pokmen = adapter.getPokmenFromPesiont(SwipedPokmenPostion);
                viewModel.DeletPoakomens(pokmen);
                adapter.notifyItemRemoved(SwipedPokmenPostion);
                Toast.makeText(FaverotPage.this, "Deleted", Toast.LENGTH_SHORT).show();
            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(binding.Rv2);

    }
}