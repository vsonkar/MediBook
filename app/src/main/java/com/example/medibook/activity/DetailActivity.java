package com.example.medibook.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.example.medibook.R;
import com.example.medibook.adapter.DateAdapter;
import com.example.medibook.adapter.TimeAdapter;
import com.example.medibook.databinding.ActivityDetailBinding;
import com.example.medibook.domain.DoctorsModel;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {
    private ActivityDetailBinding binding;
    private DoctorsModel item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        item = (DoctorsModel) getIntent().getSerializableExtra("object");
        setVariable();
        initDate();
        initTime();
    }

    private void initTime() {
        binding.timeView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.timeView.setAdapter(new TimeAdapter(generateTimeSlots()));
    }

    private void initDate() {
        binding.dateView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.dateView.setAdapter(new DateAdapter(generateDates()));
    }

    public static List<String> generateTimeSlots(){
        List<String> timeSlots = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");

        for (int i = 0; i < 24; i+=2) {
            LocalTime time = LocalTime.of(i, 0);
            timeSlots.add(time.format(formatter));
        }

        return timeSlots;
    }

    public static List<String> generateDates(){
        List<String> dates = new ArrayList<>();
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE/dd/MMM");
        for (int i = 0; i < 7; i++) {
            dates.add(today.plusDays(i).format(formatter));
        }
        return dates;
    }

    private void setVariable() {
        binding.backBtn.setOnClickListener(v -> finish());

        Glide.with(DetailActivity.this)
                .load(item.getPicture())
                .into(binding.image);

        binding.addressTxt.setText(item.getAddress());
        binding.nameeTxt.setText(item.getName());
        binding.speciallTxt.setText(item.getSpecial());
        binding.patientTxt.setText(item.getPatients()+"");
        binding.expTxt.setText(item.getExperience()+" Years");
        
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DetailActivity.this, "Appointment Booked!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}