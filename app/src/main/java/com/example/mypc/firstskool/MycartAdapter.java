package com.example.mypc.firstskool;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MycartAdapter extends RecyclerView.Adapter<MycartAdapter.CartViewHolder> {

    String[] title;
    String[] amount;
    Context context;
    public MycartAdapter(String[] title,String[] amount,Context context){
        this.title=title;
        this.amount=amount;
        this.context=context;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.card_layout,parent,false);
        return  new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        String topicTitle=title[position];
        holder.titleTextView.setText(topicTitle);
        String courseAmount=amount[position];
        holder.amountTextView.setText(courseAmount);
    }

    @Override
    public int getItemCount() {
        return title.length;
    }

    public class CartViewHolder extends RecyclerView.ViewHolder{
        TextView titleTextView;
        TextView amountTextView;
        TextView monthsTextView;
        TextView cartDiscount;
        Button buyButton;

        public CartViewHolder(View itemView) {
            super(itemView);
            titleTextView=(TextView)itemView.findViewById(R.id.cart_title);
            amountTextView=itemView.findViewById(R.id.cart_amount);
            monthsTextView=itemView.findViewById(R.id.cart_months);
            cartDiscount=itemView.findViewById(R.id.cart_discount);
            buyButton=itemView.findViewById(R.id.cart_buy_now);
        }
    }
}
