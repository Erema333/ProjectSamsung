package com.example.projectsamsung;

import static com.example.projectsamsung.GameView.info;

import static java.lang.Thread.sleep;

import androidx.annotation.Nullable;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projectsamsung.databinding.GameViewBinding;



// Класс для оброботки взаимодействий пользователя || Основная активити
public class GameActivity extends AppCompatActivity {
    private GameViewBinding binding;
    class ScoreThread implements Runnable{

        @Override
        public void run() {
            while (true){
                int text = info.getScore();
                binding.score.setText(text);
                System.out.println("Очков: "+ info.getScore());
            }
        }
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        binding = GameViewBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
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