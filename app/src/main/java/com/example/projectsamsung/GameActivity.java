package com.example.projectsamsung;


import static com.example.projectsamsung.GameView.addSprite;
import static com.example.projectsamsung.SpriteLogic.onTouchSprite;
import static com.example.projectsamsung.SpriteLogic.score;

import android.view.View;

import androidx.annotation.Nullable;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.view.MotionEvent;



import androidx.appcompat.app.AppCompatActivity;

import com.example.projectsamsung.databinding.GameViewBinding;



// TODO: Класс для оброботки взаимодействий пользователя || Основная активити
public class GameActivity extends AppCompatActivity {
long time;
    int next;
    private static GameViewBinding binding;
    private static double x,y; // координаты нажатия
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        binding = GameViewBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        time = 300;
        next = 3;
        binding.display.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) { /* TODO: при нажатии получаются координаты нажатия и
                                                                   TODO: **вызывается обновление холста** */

                x = event.getX();
                y = event.getY();
                binding.game.invalidate();
                onTouchSprite();
                System.out.println("нажал!");
                return false;
            }

        });
        // TODO: бработка нажатия на кнопку настройки
        binding.setting.setOnClickListener(v -> {

        });
        TimeTheard time = new TimeTheard();
        time.start();
    }
    public static void updateGame(){
        binding.game.invalidate();
    } // TODO: метод обновляющий холст
    //=========================================================
public class TimeTheard extends Thread{
        @Override
        public void run() {
            super.run();
            while (time > 0){
                binding.timeView.setText("time: " + time);
                binding.score.setText("score: " + score);
                if(300 - next == time) {
                    addSprite();
                    binding.game.invalidate();
                    next+=3;
                }
                try {
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            time--;
            }
            super.stop();
        }
    }


    public static double getCordX(){
        return x;
    } // методы возращающие координаты нажатия
    public static double getCordY(){
        return y;
    }

    @Override
    protected void onStop() {
        super.onStop();

    }
}