package com.example.gmailapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ImporEm extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    List<Email> emails;
    ItemClickInterface itemClickInterface;

    public ImporEm(List<Email> emails, ItemClickInterface itemClickInterface) {
        this.emails = emails;
        this.itemClickInterface = itemClickInterface;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gmail, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Log.v("TAG", "ONBINDVIEWHOLDER");
        Email email = emails.get(position);
        ((MyViewHolder)holder).iconColor.setImageResource(email.getId());

        if(email.isImportant()){
            ((MyViewHolder)holder).favorite.setVisibility(View.GONE);
            ((MyViewHolder)holder).favoriteTrue.setVisibility(View.VISIBLE);
        } else {
            ((MyViewHolder)holder).favorite.setVisibility(View.VISIBLE);
            ((MyViewHolder)holder).favoriteTrue.setVisibility(View.GONE);
        }

        ((MyViewHolder)holder).from.setText(email.getFrom());
        ((MyViewHolder)holder).time.setText(email.getTimestamp());
        ((MyViewHolder)holder).subject.setText(email.getSubject());
        ((MyViewHolder)holder).message.setText(email.getMessage());

        ((MyViewHolder)holder).icon.setText(email.getFrom().charAt(0) + "");

        ((MyViewHolder)holder).favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MyViewHolder)holder).favorite.setVisibility(View.GONE);
                ((MyViewHolder)holder).favoriteTrue.setVisibility(View.VISIBLE);
            }
        });
        ((MyViewHolder)holder).favoriteTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MyViewHolder)holder).favorite.setVisibility(View.VISIBLE);
                ((MyViewHolder)holder).favoriteTrue.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return emails.size();
    }
    public interface ItemClickInterface {
        void OnItemClick(int position);
    }
    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView iconColor, favorite, favoriteTrue;
        TextView from,time,subject,message, icon;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iconColor = itemView.findViewById(R.id.color);
            favorite = itemView.findViewById(R.id.favorite);
            favoriteTrue = itemView.findViewById(R.id.favorite_true);
            from = itemView.findViewById(R.id.from);
            time = itemView.findViewById(R.id.time);
            subject = itemView.findViewById(R.id.subject);
            message = itemView.findViewById(R.id.message);
            icon = itemView.findViewById(R.id.name);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    Log.v("TAG", "position " + pos);
                    if (itemClickInterface != null)
                        itemClickInterface.OnItemClick(pos);
                }
            });
        }
    }
}
