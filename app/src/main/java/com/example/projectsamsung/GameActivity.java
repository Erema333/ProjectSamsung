package com.example.projectsamsung;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projectsamsung.databinding.GameViewBinding;
import com.example.projectsamsung.databinding.PreViewBinding;

public class GameActivity extends AppCompatActivity {
    private GameViewBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        binding = GameViewBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(new DrawView(this));
    }
}
