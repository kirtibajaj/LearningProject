package com.example.mypc.firstskool;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Manish on 7/8/2018.
 */

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder> {

    String[] messsage;
    String[] time;
    Context context;

    public NotificationAdapter(String[] message, String[] time, Context context){
        this.messsage=message;
        this.time=time;
        this.context=context;
    }

    @NonNull
    @Override
    public NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.notification_layout,parent,false);
        return new NotificationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationViewHolder holder, int position) {
        String displayMessage=messsage[position];
        String displayTime=time[position];
        holder.notificationMessage.setText(displayMessage);
        holder.notificationTime.setText(displayTime);

    }

    @Override
    public int getItemCount() {
        return messsage.length;
    }

    public class NotificationViewHolder extends RecyclerView.ViewHolder{
        ImageView notificationImageView;
        TextView notificationMessage;
        TextView notificationTime;


        public NotificationViewHolder(View itemView) {
            super(itemView);
            notificationImageView=(ImageView)itemView.findViewById(R.id.notification_profile);
            notificationMessage=(TextView) itemView.findViewById(R.id.notification_message);
            notificationTime=(TextView)itemView.findViewById(R.id.notification_time);

        }
    }
}
