package com.example.mypc.firstskool;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class LibraryFragment extends Fragment {

    RecyclerView mLibraryRecyclerView;
    Context context=getActivity();
    String[] Subjects={"Physics","Biology","Maths","Chemistry","Social Science","English"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View libraryRootView = inflater.inflate(R.layout.library_fragment,
                container, false);

        mLibraryRecyclerView =(RecyclerView) libraryRootView.findViewById(R.id.library_recyclerview);

        mLibraryRecyclerView.setLayoutManager(new LinearLayoutManager(context));

        mLibraryRecyclerView.setAdapter(new LibraryAdapter(Subjects,context));

        return libraryRootView;
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
