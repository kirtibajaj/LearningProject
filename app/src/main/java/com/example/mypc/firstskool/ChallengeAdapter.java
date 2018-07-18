package com.example.mypc.firstskool;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ChallengeAdapter extends RecyclerView.Adapter<ChallengeAdapter.ChallengeViewHolder> {
    String[] subjects;
    Context context;

    public ChallengeAdapter(String[] subjects,Context context){
        this.subjects=subjects;
        this.context=context;
    }

    @NonNull
    @Override
    public ChallengeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.challenge_layout,parent,false);
        return new ChallengeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChallengeViewHolder holder, int position) {
        String subject=subjects[position];
        holder.mChallengeSubjectView.setText(subject);
    }

    @Override
    public int getItemCount() {
        return  subjects.length;
    }

    public class ChallengeViewHolder extends RecyclerView.ViewHolder{
        TextView mChallengeSubjectView;

        public ChallengeViewHolder(View itemView) {
            super(itemView);
            mChallengeSubjectView=itemView.findViewById(R.id.challenge_subject);
        }
    }
}