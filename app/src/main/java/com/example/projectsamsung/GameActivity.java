package com.example.projectsamsung;

import static android.app.PendingIntent.getActivity;
import static android.os.SystemClock.sleep;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projectsamsung.databinding.GameViewBinding;


import java.util.Calendar;
import java.util.Date;
import java.util.TreeMap;


// TODO: Класс для оброботки взаимодействий пользователя || Основная активити
public class GameActivity extends AppCompatActivity {
    Date dt = Calendar.getInstance().getTime();
long time;

    private GameViewBinding binding;
    private static double x,y; // координаты нажатия
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        binding = GameViewBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        time = 0;
        binding.display.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) { /* TODO: при нажатии получаются координаты нажатия и
                                                                   TODO: **вызывается обновление холста** */
               GameView.addStation();
                x = event.getX();
                y = event.getY();
                binding.game.invalidate();
                return false;
            }

        });
        // TODO: бработка нажатия на кнопку настройки
        binding.setting.setOnClickListener(v -> {

        });
        TimeTheard time = new TimeTheard();
        time.start();
    }
    //=========================================================
public class TimeTheard extends Thread{
        @Override
        public void run() {
            super.run();
            while (true){
                binding.timeView.setText("time: " + time);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                time ++;
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();



    }

    public static double getCordX(){
        return x;
    } // методы возращающие координаты нажатия
    public double getCordY(){
        return y;
    }
};