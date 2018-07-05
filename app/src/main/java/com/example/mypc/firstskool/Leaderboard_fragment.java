package com.example.mypc.firstskool;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Leaderboard_fragment extends Fragment {

    /*fragment containing the leaderboard lists of any particular
    * course which are same in behaviour but the data will be changed
    * and will be fetched on the runtime accordingly*/

    private RecyclerView recyclerView;
    private ArrayList<String> list=new ArrayList<>();

    //custom adapter made
    private Leaderboard_list_adapter adapter;
    private String argument;

    public Leaderboard_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_leaderboard_fragment, container, false);
        recyclerView=view.findViewById(R.id.recyclerview);

        //TODO: add code for fetching the content from leaderboard activity

        Bundle bundle=getArguments();
        argument=bundle.getString("leaderboard");

        setList();

        Toast.makeText(getContext(),"IN the fragment",Toast.LENGTH_LONG).show();

        adapter=new Leaderboard_list_adapter(list,getContext());

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        return view;
    }

    private void setList() {
        //demo inserts
        for (int i=0;i<50;i++){
            list.add(argument+" name "+i);
        }
    }

}
