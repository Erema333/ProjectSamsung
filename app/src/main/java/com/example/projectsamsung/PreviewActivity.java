package com.example.projectsamsung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import com.example.projectsamsung.databinding.PreViewBinding;


public class PreviewActivity extends AppCompatActivity {
    private PreViewBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = PreViewBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        binding.cont.setOnClickListener(view -> {
            Intent intent = new Intent();

            intent.setClass(PreviewActivity.this, GameActivity.class);

        });

    }

}