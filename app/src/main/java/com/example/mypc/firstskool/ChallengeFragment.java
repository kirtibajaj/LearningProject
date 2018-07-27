package com.example.mypc.firstskool;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ChallengeFragment extends Fragment{

    RecyclerView mChallengeRecyclerView;
    Context context;
    String[] Subjects={"Physics","Biology","Maths","Chemistry","Social Science","Logical Reasoning"};


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.challenge_fragment,
                container, false);

        mChallengeRecyclerView=(RecyclerView) rootView.findViewById(R.id.challenge_recyclerview);

        mChallengeRecyclerView.setLayoutManager(new LinearLayoutManager(context));

        mChallengeRecyclerView.setAdapter(new ChallengeAdapter(Subjects,context));
        Log.d("ChallengeFragment","rottview");
        return rootView;
    }




    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
    }
    @Override
    public void onStop() {
        super.onStop();
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
    }
}
