package com.example.mypc.firstskool;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class LibraryAdapter extends RecyclerView.Adapter<LibraryAdapter.LibraryViewHolder> {
    String[] subjects;
    Context context;

    public LibraryAdapter(String[] subjects, Context context) {
        this.subjects = subjects;
        this.context = context;
    }

    @NonNull
    @Override
    public LibraryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.library_layout, parent, false);
        return new LibraryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LibraryViewHolder holder, int position) {
        String subject = subjects[position];
        holder.mLibrarySubjectView.setText(subject);
    }

    @Override
    public int getItemCount() {
        return subjects.length;
    }

    public class LibraryViewHolder extends RecyclerView.ViewHolder {
        TextView mLibrarySubjectView;

        public LibraryViewHolder(View itemView) {
            super(itemView);
            mLibrarySubjectView = itemView.findViewById(R.id.library_subject);
        }
    }
}