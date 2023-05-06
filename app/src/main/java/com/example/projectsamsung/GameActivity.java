package com.example.projectsamsung;

import androidx.annotation.Nullable;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projectsamsung.databinding.GameViewBinding;



// Класс для оброботки взаимодействий пользователя || Основная активити
public class GameActivity extends AppCompatActivity {
    private GameViewBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        binding = GameViewBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.setting.setOnClickListener(v -> {
            SettingGameFragmet fragment = new SettingGameFragmet();
            getSupportFragmentManager().beginTransaction().replace(R.id.setting_layout, fragment).commit();
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        binding.game.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
        binding.game.onStop();
    }
}