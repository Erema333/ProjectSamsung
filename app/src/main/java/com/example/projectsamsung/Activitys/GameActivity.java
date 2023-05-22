package com.example.projectsamsung.Activitys;

import static com.example.projectsamsung.GameView.info;

import static java.lang.Thread.sleep;

import androidx.annotation.Nullable;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projectsamsung.GameInfoListener;
import com.example.projectsamsung.databinding.GameViewBinding;


// Класс для оброботки взаимодействий пользователя || Основная активити
public class GameActivity extends AppCompatActivity implements GameInfoListener {
    private GameViewBinding binding;
    ScoreThread sc = new ScoreThread();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        binding = GameViewBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        if(info.getMissingSprite() >= 3)info.callingBack(GameActivity.this);
        sc.start();
        if(info.getMissingSprite() >= 3)info.callingBack(GameActivity.this);
    }
    public android.content.res.Resources Resources(){
        return getResources();
    }
public void changeActivity(){
        sc.interrupt();
    Intent intent = new Intent();
    intent.setClass(GameActivity.this, PreviewActivity.class);
    startActivity(intent);
    System.out.println("ОНО ЖИВОЕ");
    finish();
}
    @Override
    public void callingBack(GameActivity activty) {

activty.changeActivity();
    }
    public  void invisible(){

        binding.timer.setVisibility(View.INVISIBLE);
    }
    public  void visible(){
        binding.timer.setVisibility(View.VISIBLE);
    }




    class ScoreThread extends Thread{
        @SuppressLint("ResourceType")
        @Override
        public void run() {
            while (true){

if(info.getBossMode()){
  //  info.visibleView(GameActivity.this);
    binding.timer.setText(Integer.toString(info.getTimeBoss()));
}
else {
    // info.invisibleView(GameActivity.this);
}
                binding.score.setText(Integer.toString(info.getScore()));


                if(info.getMissingSprite() >= 3){
                    Handler handler = new Handler(getMainLooper());
                    handler.obtainMessage(11, GameActivity.this);
                }

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
        Intent iii = new Intent();
        iii.setClass(GameActivity.this, PreviewActivity.class);
        startActivity(iii);
        super.onStop();
        binding.game.onStop();

    }
}