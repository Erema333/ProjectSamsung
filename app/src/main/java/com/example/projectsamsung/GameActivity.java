package com.example.projectsamsung;

import static com.example.projectsamsung.GameView.info;

import static java.lang.Thread.sleep;

import androidx.annotation.Nullable;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projectsamsung.databinding.GameViewBinding;



// Класс для оброботки взаимодействий пользователя || Основная активити
public class GameActivity extends AppCompatActivity implements GameInfo.CallbackA {
    private GameViewBinding binding;
    ScoreThread sc = new ScoreThread();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        binding = GameViewBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        sc.start();

    }

    @Override
    public void callingBack() {
        Intent intent = new Intent();
        intent.setClass(GameActivity.this, GameOverActivity.class);
        startActivity(intent);
    }


    class ScoreThread extends Thread{
        @SuppressLint("ResourceType")
        @Override
        public void run() {
            while (true){


                binding.score.setText(Integer.toString(info.getScore()));

}
            }
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
        Intent iii = new Intent();
        iii.setClass(GameActivity.this, PreviewActivity.class);
        startActivity(iii);
    }
}