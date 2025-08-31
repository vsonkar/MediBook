package com.example.medibook.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medibook.R;
import com.example.medibook.databinding.ViewholderDateBinding;
import com.example.medibook.databinding.ViewholderTimeBinding;

import java.util.List;

public class TimeAdapter extends RecyclerView.Adapter<TimeAdapter.TimeViewholder> {
    private final List<String> timeSlots;
    private int selectedPosition = -1;
    private int lastSelectedPosition = -1;

    public TimeAdapter(List<String> timeSlots) {
        this.timeSlots = timeSlots;
    }


    @NonNull
    @Override
    public TimeAdapter.TimeViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewholderTimeBinding binding = ViewholderTimeBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false);
        return new TimeViewholder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull TimeAdapter.TimeViewholder holder, int position) {
        holder.setBinding(timeSlots.get(position), position, this);

    }

    @Override
    public int getItemCount() {
        return timeSlots.size();
    }

    public class TimeViewholder extends RecyclerView.ViewHolder {
        private final ViewholderTimeBinding binding;
        public TimeViewholder(ViewholderTimeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void setBinding(String time, int position, TimeAdapter adapter){
            binding.timetxt.setText(time);
            if(adapter.selectedPosition==position) {
                binding.timetxt.setBackgroundResource(R.drawable.blue_btn_bg);
                binding.timetxt.setTextColor(ContextCompat.getColor(binding.getRoot().getContext(), R.color.white));
            } else {
                binding.timetxt.setBackgroundResource(R.drawable.light_grey_bg);
                binding.timetxt.setTextColor(ContextCompat.getColor(binding.getRoot().getContext(), R.color.black));

                binding.getRoot().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        adapter.lastSelectedPosition = adapter.selectedPosition;
                        adapter.selectedPosition = position;
                        adapter.notifyItemChanged(adapter.lastSelectedPosition);
                        adapter.notifyItemChanged(adapter.selectedPosition);
                    }
                });
            }
        }
    }
}
