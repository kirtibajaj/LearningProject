package com.example.mypc.firstskool;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Leaderboard_list_adapter extends RecyclerView.Adapter<Leaderboard_list_adapter.Leaderboard_Holder> {

    /*Custom adapter made for the leaderboard lists
    * and the recylerviews in the fragmenst */

    private ArrayList<String> names;
    private Context context;

    public Leaderboard_list_adapter(ArrayList<String> names, Context context) {
        this.names = names;
        this.context = context;
    }

    @NonNull
    @Override
    public Leaderboard_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.leaderboard_item,parent,false);
        Leaderboard_Holder holder=new Leaderboard_Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Leaderboard_Holder holder, int position) {
        String name=names.get(position);
        holder.name.setText(name);

        //demo positon to be changed by profile class position element
        holder.pos.setText(1+"");
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    class Leaderboard_Holder extends RecyclerView.ViewHolder{

        /*Dem items contained in one item of the leaderboard list
        * which are to be chnaged accordingly */

        View view;
        TextView name;
        TextView pos;
        ImageView icon;

        public Leaderboard_Holder(View itemView) {
            super(itemView);
            view=itemView;
            this.name=itemView.findViewById(R.id.name);
            this.icon=itemView.findViewById(R.id.icon);
            this.pos=itemView.findViewById(R.id.position);
        }
    }
}
