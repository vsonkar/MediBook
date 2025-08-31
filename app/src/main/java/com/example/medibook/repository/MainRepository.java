package com.example.medibook.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.medibook.domain.CategoryModel;
import com.example.medibook.domain.DoctorsModel;
import com.google.firebase.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainRepository {
    private final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance("https://medibook-1aaf0-default-rtdb.asia-southeast1.firebasedatabase.app");

    public LiveData<List<CategoryModel>> loadCategory(){
        final MutableLiveData<List<CategoryModel>> listData = new MutableLiveData<>();
        DatabaseReference reference = firebaseDatabase.getReference("Category");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<CategoryModel> lists = new ArrayList<>();
                for(DataSnapshot childSnapshot: snapshot.getChildren()){
                    CategoryModel item = childSnapshot.getValue(CategoryModel.class);
                    if(item!=null){
                        lists.add(item);

                    }
                }
                listData.setValue(lists);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return listData;

    }

    public LiveData<List<DoctorsModel>> loadDoctor(){
        final MutableLiveData<List<DoctorsModel>> liveData = new MutableLiveData<>();
        DatabaseReference reference = firebaseDatabase.getReference("Doctors");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<DoctorsModel> lists = new ArrayList<>();
                for(DataSnapshot childSnapshot : snapshot.getChildren()){
                    DoctorsModel item = childSnapshot.getValue(DoctorsModel.class);
                    if(item!=null){
                        lists.add(item);
                    }
                }
                liveData.setValue(lists);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return liveData;
    }
}
