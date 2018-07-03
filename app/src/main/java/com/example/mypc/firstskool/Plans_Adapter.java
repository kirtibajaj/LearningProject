package com.example.mypc.firstskool;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Plans_Adapter extends RecyclerView.Adapter<Plans_Adapter.Plan_Holder> {

    interface Plan_Item_Listner{
        void onItemClick(int position);
    }

    ArrayList<My_Plan_Item> list;
    Context context;
    Plan_Item_Listner mListner;

    public Plans_Adapter(ArrayList<My_Plan_Item> list, Context context, Plan_Item_Listner mListner) {
        this.list = list;
        this.context = context;
        this.mListner = mListner;
    }

    @NonNull
    @Override
    public Plan_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.my_plan_item,parent,false);
        Plan_Holder userViewHolder=new Plan_Holder(view);
        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final Plan_Holder holder, final int position) {
        My_Plan_Item item=list.get(position);
        holder.type_of_plan.setText(item.getType());
        holder.title.setText(item.getTitle());
        holder.overview.setText(item.getOverview());
        holder.fees.setText(item.getFees());
        holder.status.setText(item.getStatus()+"     %");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListner.onItemClick(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Plan_Holder extends RecyclerView.ViewHolder{

        View itemView;
        TextView type_of_plan;
        TextView title;
        TextView fees;
        TextView overview;
        TextView status;

        public Plan_Holder(View itemView) {
            super(itemView);
            this.itemView=itemView;
            this.title=itemView.findViewById(R.id.title);
            this.fees=itemView.findViewById(R.id.fees);
            this.status=itemView.findViewById(R.id.status);
            this.type_of_plan=itemView.findViewById(R.id.type);
            this.overview=itemView.findViewById(R.id.overview);
        }
    }
}
