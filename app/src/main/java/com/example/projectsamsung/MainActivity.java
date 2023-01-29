package com.example.projectsamsung;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.projectsamsung.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    public int level;
    public int name;
    //-------------onCreate---------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        level = 0;
        name = 1;
        Station count1 = new Station(name,(Math.random()*((50-0)+1))+0,(Math.random()*((50-0)+1))+0);
        name++;
        Station count2 = new Station(name,(Math.random()*((50-0)+1))+0,(Math.random()*((50-0)+1))+0);
        name++;
        Station count3 = new Station(name,(Math.random()*((50-0)+1))+0,(Math.random()*((50-0)+1))+0);
        name++;
        Station count4 = new Station(name,(Math.random()*((50-0)+1))+0,(Math.random()*((50-0)+1))+0);
    }
    //-------------------------------------------------





}
