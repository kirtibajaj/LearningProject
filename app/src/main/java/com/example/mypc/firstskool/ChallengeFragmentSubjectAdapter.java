package com.example.mypc.firstskool;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ChallengeFragmentSubjectAdapter extends RecyclerView.Adapter<ChallengeFragmentSubjectAdapter.ChallengeFragmentSubjectViewHolder> {

    String[] topics;
    Context context;
    public ChallengeFragmentSubjectAdapter(String[] topics, Context context){
        this.topics=topics;
        this.context=context;
    }
    @NonNull
    @Override
    public ChallengeFragmentSubjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.challenge_fragment_subject_layout,parent,false);
        return new ChallengeFragmentSubjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChallengeFragmentSubjectViewHolder holder, int position) {
        String topic=topics[position];
        holder.mChallengeSubjectTopicTextView.setText(topic);

    }

    @Override
    public int getItemCount() {
        return topics.length;
    }

    public class ChallengeFragmentSubjectViewHolder extends RecyclerView.ViewHolder{
        TextView mChallengeSubjectTopicTextView;
        public ChallengeFragmentSubjectViewHolder(View itemView) {
            super(itemView);
            mChallengeSubjectTopicTextView= itemView.findViewById(R.id.challenge_fragment_topic);
        }
    }
}
