package com.salman.getgithubofgeek.Activity.Activity.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.salman.getgithubofgeek.R;


public class RecViewHolder extends RecyclerView.ViewHolder {

    ImageView followersImageView;
    TextView followersTextView;

    public RecViewHolder(View itemView) {
        super(itemView);
        followersImageView=itemView.findViewById(R.id.followersImage);
        followersTextView=itemView.findViewById(R.id.followersText);
    }

}
