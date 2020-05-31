package com.example.eco_impulse.holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eco_impulse.R;
import com.example.eco_impulse.modelos.Post;

public class PostViewHolder extends RecyclerView.ViewHolder {

    public TextView tvPostTittle;
    public ImageView ivPostImage, ivLike, ivComments;

    public PostViewHolder(@NonNull View itemView) {
        super(itemView);
        tvPostTittle = (TextView) itemView.findViewById(R.id.tvPostTittle);
        ivPostImage = (ImageView) itemView.findViewById(R.id.ivPostImage);
        ivComments = (ImageView) itemView.findViewById(R.id.ivComments);
        ivLike = (ImageView) itemView.findViewById(R.id.ivLike);
        ivLike.setImageDrawable(itemView.getResources().getDrawable(R.drawable.heart_red));
        ivComments.setImageDrawable(itemView.getResources().getDrawable(R.drawable.ic_message_gray_24dp));
    }

    public void updateUI(Post post){
        tvPostTittle.setText(post.getTittle());
        if(post.imageId!=0){
            ivPostImage.setImageDrawable(itemView.getResources().getDrawable(post.imageId));
        }else {
            //Cargaomos con Glide
        }
    }


}
