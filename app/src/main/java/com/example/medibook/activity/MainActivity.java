package com.example.medibook.activity;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.medibook.adapter.CategoryAdapter;
import com.example.medibook.adapter.TopDoctorsAdapter;
import com.example.medibook.databinding.ActivityMainBinding;
import com.example.medibook.viewModel.MainViewModel;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        viewModel = new MainViewModel();
        setContentView(binding.getRoot());

        initCategory();
        initTopDoctors();

    }

    private void initTopDoctors() {
        binding.progressBarDoctor.setVisibility(VISIBLE);
        viewModel.loadDoctors().observe(this, doctorsModels -> {
            binding.doctorView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
            binding.doctorView.setAdapter(new TopDoctorsAdapter(doctorsModels));
            binding.progressBarDoctor.setVisibility(GONE);
        });
    }

    private void initCategory() {
        binding.progressBarCat.setVisibility(VISIBLE);

        viewModel.loadCategory().observe(this, categoryModels -> {
            binding.cartView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
            binding.cartView.setAdapter(new CategoryAdapter(categoryModels));
            binding.progressBarCat.setVisibility(GONE);
        });
    }
}