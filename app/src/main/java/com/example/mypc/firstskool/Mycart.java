package com.example.mypc.firstskool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class Mycart extends AppCompatActivity {
    // Activity class for mycart icon at action bar
    String[] title={"Art Design", "Paper design"};
    String[] amount={"Rs. 999","Rs. 2500"};
    RecyclerView cartRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mycart);
        cartRecyclerView=(RecyclerView)findViewById(R.id.cart_recyclerview);
        cartRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        cartRecyclerView.setAdapter(new MycartAdapter(title,amount,this));
    }
}
