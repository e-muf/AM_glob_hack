package com.example.eco_impulse.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eco_impulse.R;
import com.example.eco_impulse.holders.MeetingViewHolder;
import com.example.eco_impulse.modelos.Meeting;

import java.util.ArrayList;

public class MeetingAdapter extends RecyclerView.Adapter<MeetingViewHolder> {

    ArrayList<Meeting> items;
    Context context;

    public MeetingAdapter(ArrayList<Meeting> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public MeetingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View itemView = LayoutInflater.from(context).inflate(R.layout.card_meeting, parent, false);
        return new MeetingViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MeetingViewHolder holder, int position) {
        holder.updateUi(items.get(position));
        holder.ivMeetingImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
