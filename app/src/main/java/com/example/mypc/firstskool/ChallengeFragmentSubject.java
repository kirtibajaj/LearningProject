package com.example.mypc.firstskool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class ChallengeFragmentSubject extends AppCompatActivity {

    public String[] topics={"Gravity","Laws of motion","Thermodynamics","Units and measurements","Waves","Motion","Circular motion"};
    RecyclerView mChallengeFragmentSubjectRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_fragment_subject);
        mChallengeFragmentSubjectRecyclerView=(RecyclerView)findViewById(R.id.challenge_fragment_subject_recyclerview);
        mChallengeFragmentSubjectRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mChallengeFragmentSubjectRecyclerView.setAdapter(new ChallengeFragmentSubjectAdapter(topics,this));
    }
}
