package com.example.projectsamsung;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.projectsamsung.databinding.GameViewBinding;

public class SettingGameFragmet extends Fragment {
   @Nullable
   @Override
   public View onCreateView(
           @NonNull LayoutInflater inflater,
           @Nullable ViewGroup container,
           @Nullable Bundle savedInstanceState) {
      inflater.inflate(R.layout.setting_fragment_view, container,false);
      binding = GameViewBinding.inflate(inflater,container,false);
      return binding.getRoot();
   }

   private GameViewBinding binding;


}
