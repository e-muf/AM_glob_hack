package com.example.eco_impulse.holders;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eco_impulse.R;
import com.example.eco_impulse.modelos.Meeting;

public class MeetingViewHolder extends RecyclerView.ViewHolder {

    public TextView tvMeetingTittle, tvMeetingDate, tvMeetingLocation;
    public ImageView ivMeetingImage, ivMeetingLike, ivMeetingLocation, ivMeetingSuscribe, ivMeetingDate;

    public MeetingViewHolder(@NonNull View itemView) {
        super(itemView);

        tvMeetingTittle = (TextView)itemView.findViewById(R.id.tvMeetingTittle);
        tvMeetingDate = (TextView)itemView.findViewById(R.id.tvMeetingDate);
        tvMeetingLocation = (TextView)itemView.findViewById(R.id.tvMeetingLocation);
        ivMeetingImage = (ImageView)itemView.findViewById(R.id.ivMeetingImage);
        ivMeetingLike = (ImageView)itemView.findViewById(R.id.ivMeetingLike);
        ivMeetingLocation = (ImageView)itemView.findViewById(R.id.ivMeetingLocation);
        ivMeetingSuscribe = (ImageView)itemView.findViewById(R.id.ivMeetingSuscribe);
        ivMeetingDate = (ImageView)itemView.findViewById(R.id.ivMeetingDate);

        ivMeetingLike.setImageDrawable(itemView.getResources().getDrawable(R.drawable.heart_red));
        ivMeetingLocation.setImageDrawable(itemView.getResources().getDrawable(R.drawable.ic_location_gray_24dp));
        ivMeetingSuscribe.setImageDrawable(itemView.getResources().getDrawable(R.drawable.ic_assignment_gray_24dp));
        ivMeetingDate.setImageDrawable(itemView.getResources().getDrawable(R.drawable.ic_clock_gray_24dp));
    }

    public void updateUi(Meeting item){
        tvMeetingTittle.setText(item.getTittle());
        tvMeetingDate.setText(item.getDate());
        tvMeetingLocation.setText(item.getLocation());
        if(item.imageId!=0){
            ivMeetingImage.setImageDrawable(itemView.getResources().getDrawable(item.imageId));
            Log.i("MVH-Item", item.getTittle() + " cargado con éxito!");
        }else{
            //Cargamos con glide :)
        }
    }
}
