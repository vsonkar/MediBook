package com.example.medibook.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.medibook.domain.CategoryModel;
import com.example.medibook.domain.DoctorsModel;
import com.example.medibook.repository.MainRepository;

import java.util.List;

public class MainViewModel extends ViewModel {
    private final MainRepository repository;

    public MainViewModel() {
        this.repository = new MainRepository();
    }

    public LiveData<List<CategoryModel>> loadCategory(){
        return repository.loadCategory();
    }

    public LiveData<List<DoctorsModel>> loadDoctors(){
        return repository.loadDoctor();
    }
}
