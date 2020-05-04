package com.example.preferancesandrecycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FibonacciListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerViewFibonacciAdapter adapter;
//    public static final String SHARED_PREF = "sharedRef";
//    public static final String History = "history";
    public ArrayList<Long> fibList;
    public  ArrayList<String> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        loadData();
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fibonacci_list);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        int nums = getIntent().getIntExtra("nums", 1);
        //fibList = FibonacciNumbersCalculator.getNums(nums);
        adapter = new RecyclerViewFibonacciAdapter(fibList);
        recyclerView.setAdapter(adapter);
    }

    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences("sharedRef", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("history", null);
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        if (gson.fromJson(json, type) == null){

            fibList = new ArrayList<>();
        } else {
            list =  gson.fromJson(json, type);
            fibList = ArrayListConverterToLong.stringsToLongs(list);
            //Log.i("myTag", String.valueOf(fibList));
        }
    }

}