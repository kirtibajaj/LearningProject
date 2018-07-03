package com.example.mypc.firstskool;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class My_Plan_Activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<My_Plan_Item> list=new ArrayList<>();
    private Plans_Adapter plans_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my__plan_);

        Intent intent=getIntent();

        init();

        //demo inserts into list:

        for(int i=0;i<10;i++){
            My_Plan_Item item=new My_Plan_Item("current plan"+i+"",
                    "2000 $","Demo","this is a demo plan !", 0);
            list.add(item);
        }
        plans_adapter.notifyDataSetChanged();

        recyclerView.setAdapter(plans_adapter);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL));

    }

    private void init() {
        recyclerView=findViewById(R.id.recyclerview);
        plans_adapter=new Plans_Adapter(list, My_Plan_Activity.this, new Plans_Adapter.Plan_Item_Listner() {
            @Override
            public void onItemClick(int position) {
                //TODO : handle the item click
            }
        });
    }
}
