package com.example.mypc.firstskool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class Courses extends AppCompatActivity {

    private RecyclerView recyclerView1, recyclerView2;
    private RecyclerView.LayoutManager layoutManager, layoutManager2;
    private List<String> listClass;
    private List<String> listExams;
    private RecyclerViewAdapter adapter, adapter2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        // ----------- First Recycler view for class ------------------------

        recyclerView1 = findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView1.setLayoutManager(layoutManager);
        listClass = Arrays.asList(getResources().getStringArray(R.array.Class));
        adapter = new RecyclerViewAdapter(listClass);
        recyclerView1.setHasFixedSize(true);
        recyclerView1.setAdapter(adapter);



        // --------------- Second recycler view for Exams --------------------
        recyclerView2 = findViewById(R.id.recyclerviewexams);
        layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView2.setLayoutManager(layoutManager2);
        listExams = Arrays.asList(getResources().getStringArray(R.array.Exams));
        adapter2 = new RecyclerViewAdapter(listExams);
        recyclerView2.setAdapter(adapter2);


    }
}
