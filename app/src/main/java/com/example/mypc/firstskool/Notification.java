package com.example.mypc.firstskool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class Notification extends AppCompatActivity {
    //Dummy data for display of notification
    String[] message={"Daily quiz for class 9 Biology","Daily quiz for class 9 Maths"};
    String[] time={"8 July @ 10:15 AM","5 March @ 5:12PM"};

    // Refernece to RecyclerView
    RecyclerView mNotificationRecyclerView;

    // class file for notification at action bar
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        mNotificationRecyclerView=(RecyclerView)findViewById(R.id.notification_recyclerview);
        mNotificationRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mNotificationRecyclerView.setAdapter(new NotificationAdapter(message,time,this));
        mNotificationRecyclerView.addItemDecoration(new DividerItemDecoration(mNotificationRecyclerView.getContext(), DividerItemDecoration.VERTICAL));


    }
}
