package com.example.projectsamsung.Activitys;
import static com.example.projectsamsung.GameView.info;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projectsamsung.databinding.GameoverViewBinding;

public class GameOverActivity extends AppCompatActivity {
    private GameoverViewBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = GameoverViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.scoreees.setText(Integer.toString(info.getScore()));
}

    @Override
    protected void onStop() {
        Intent iii = new Intent();
        iii.setClass(GameOverActivity.this, PreviewActivity.class);
        startActivity(iii);
        super.onStop();
    }
}
