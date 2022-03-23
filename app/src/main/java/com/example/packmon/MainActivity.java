package com.example.packmon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        adapter =new PackmonAdapter(this);
        binding.Rv.setAdapter(adapter);
        viewModel = new ViewModelProvider(this).get(PackmenoViewModel.class);
        viewModel.getPackmoens();

        viewModel.getPokmenList().observe(this, new Observer<ArrayList<Pokmen>>() {
            @Override
            public void onChanged(ArrayList<Pokmen> pokmen) {
                adapter.setPokmenlist(pokmen);
            }
        });
    }
}