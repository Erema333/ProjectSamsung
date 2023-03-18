package com.example.projectsamsung;

import static android.os.SystemClock.sleep;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projectsamsung.databinding.GameViewBinding;

import java.util.Arrays;

public class GameActivity extends AppCompatActivity {
    private GameViewBinding binding;
    private static double x,y; // координаты нажатия
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        binding = GameViewBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        binding.display.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) { /* TODO: при нажатии получаются координаты нажатия и
                                                                   TODO: **вызывается обновление холста** */
                x = event.getX();
                y = event.getY();
                binding.game.invalidate();
                return false;
            }

        });
    }
    public static double getCordX(){
        return x;
    } // методы возращающие координаты нажатия
    public double getCordY(){
        return y;
    }
};