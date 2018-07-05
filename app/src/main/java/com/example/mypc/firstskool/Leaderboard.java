package com.example.mypc.firstskool;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toolbar;

public class Leaderboard extends AppCompatActivity {


    //framelayout to be replaced by the selected fragment
    private FrameLayout container;


    /*3 buttons for the three courses running for the user
    * which can vary
    * so to be chnaged accordingly*/


    private Button button1;
    private Button button2;
    private Button button3;

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);

        Intent intent=getIntent();

         android.support.v7.widget.Toolbar myToolbar = findViewById(R.id.custom_toolbar);
        setSupportActionBar(myToolbar);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        init();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Leaderboard_fragment fragment=new Leaderboard_fragment();
                Bundle bundle=new Bundle();
                fragment.setArguments(bundle);
                bundle.putString("leaderboard","demo1");

                fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

                fragmentTransaction.replace(R.id.container,fragment);
                fragmentTransaction.commit();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Leaderboard_fragment fragment=new Leaderboard_fragment();
                Bundle bundle=new Bundle();
                fragment.setArguments(bundle);
                bundle.putString("leaderboard","demo2");

                fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

                fragmentTransaction.replace(R.id.container,fragment);
                fragmentTransaction.commit();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Leaderboard_fragment fragment=new Leaderboard_fragment();
                Bundle bundle=new Bundle();
                fragment.setArguments(bundle);
                bundle.putString("leaderboard","demo3");

                fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

                fragmentTransaction.replace(R.id.container,fragment);
                fragmentTransaction.commit();
            }
        });
    }

    private void init() {
        button1=findViewById(R.id.topic1);
        button2=findViewById(R.id.topic2);
        button3=findViewById(R.id.topic3);
    }
}
